package cn.kancms.management.service;

import cn.kancms.model.management.pojo.Video;
import cn.kancms.model.management.pojo.VideoLink;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface VideoService extends IService<Video> {
    Object create(Video video, List<VideoLink> links);
    void removeAll();
}
