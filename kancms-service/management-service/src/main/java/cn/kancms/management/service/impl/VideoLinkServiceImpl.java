package cn.kancms.management.service.impl;

import cn.kancms.management.mapper.VideoLinkMapper;
import cn.kancms.management.service.VideoLinkService;
import cn.kancms.model.management.pojo.VideoLink;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service("videoLinkService")
public class VideoLinkServiceImpl extends ServiceImpl<VideoLinkMapper, VideoLink> implements VideoLinkService {
    @Override
    public void removeAll() {
        this.baseMapper.removeAll();
    }
}
