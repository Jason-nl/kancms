package cn.kancms.management.service;

import cn.kancms.model.management.pojo.VideoLink;
import com.baomidou.mybatisplus.extension.service.IService;

public interface VideoLinkService extends IService<VideoLink> {
    void removeAll();
}
