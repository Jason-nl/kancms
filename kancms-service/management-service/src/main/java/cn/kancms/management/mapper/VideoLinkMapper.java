package cn.kancms.management.mapper;

import cn.kancms.model.management.pojo.VideoLink;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Update;

public interface VideoLinkMapper extends BaseMapper<VideoLink> {
    @Update("truncate table tb_video_link")
    void removeAll();
}
