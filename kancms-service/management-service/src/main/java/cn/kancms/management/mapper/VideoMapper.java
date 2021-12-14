package cn.kancms.management.mapper;

import cn.kancms.model.management.pojo.Video;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Update;

public interface VideoMapper extends BaseMapper<Video> {
    @Update("truncate table tb_video")
    void removeAll();
}
