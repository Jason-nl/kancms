package cn.kancms.management.service.impl;

import cn.kancms.management.mapper.VideoMapper;
import cn.kancms.management.service.VideoLinkService;
import cn.kancms.management.service.VideoService;
import cn.kancms.model.management.pojo.Video;
import cn.kancms.model.management.pojo.VideoLink;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("videoService")
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {
    @Resource
    private VideoLinkService videoLinkService;
    private Video dbVideo;

    @Override
    public Object create(Video video, List<VideoLink> videoLinks) {
        // 插入之前查重复
        dbVideo = this.query().eq(StringUtils.isEmpty(video.getName()), "name", video.getName()).one();
        batchUpdateVideoList(video.getUpdateAt(), videoLinks);
        // 存在重名以及抓取时间和db时间一致 不往下执行
        if (!ObjectUtils.isEmpty(dbVideo) && isConsistentWithUpdateAt(video.getUpdateAt())) return Map.of("id", dbVideo.getId());
        // 不存在重复名称 录入一条video数据以及视频列表
        save(video);
        Long videoId = video.getId();
        batchEntryVideoLink(videoLinks, videoId);
        return Map.of("id", videoId);
    }

    /**
     * 批量录入更新视频链接
     *
     * @param videoLinks
     * @param id
     */
    private void batchEntryVideoLink(List<VideoLink> videoLinks, Long id) {
        List<VideoLink> links = videoLinks.stream()
                .map(link -> new VideoLink(link.getId(), id, link.getUrl()))
                .collect(Collectors.toList());
        videoLinkService.saveOrUpdateBatch(links);
    }

    /**
     * 比较URL与DB URL是否一致
     * @param link
     * @return
     */
    private boolean sameLink(VideoLink link) {
        VideoLink url = videoLinkService.query().eq("url", link.getUrl()).one();
        return ObjectUtils.isEmpty(url);
    }

    /**
     * 更新video的更新时间以及视频播放链接
     *
     * @param updateAt
     * @param links
     */
    private void batchUpdateVideoList(String updateAt, List<VideoLink> links) {
        // 如果数据已存在重复名称且更新时间不一致 更新视频列表
        // update set update_at = '2021-12-14 21:01:00' from tb_video where id = 19
        if (!ObjectUtils.isEmpty(dbVideo) && !isConsistentWithUpdateAt(updateAt)) {
            dbVideo.setUpdateAt(updateAt);
            updateById(dbVideo);
            batchEntryVideoLink(distinct(links), dbVideo.getId());
        }
    }

    /**
     * 去重URL
     * @param links
     * @return
     */
    private List<VideoLink> distinct(List<VideoLink> links) {
        return links.stream().filter(this::sameLink).collect(Collectors.toList());
    }

    /**
     * 更新时间与DB更新时间是否一致
     * @param updateAt
     * @return
     */
    private boolean isConsistentWithUpdateAt(String updateAt) {
        return dbVideo.getUpdateAt().equals(updateAt);
    }

    @Override
    public void removeAll() {
        this.baseMapper.removeAll();
        videoLinkService.removeAll();
    }
}
