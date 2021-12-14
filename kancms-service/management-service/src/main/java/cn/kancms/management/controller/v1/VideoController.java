package cn.kancms.management.controller.v1;

import cn.kancms.management.service.VideoService;
import cn.kancms.model.management.pojo.Video;
import cn.kancms.model.management.pojo.VideoLink;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/v1/video")
public class VideoController {
    @Resource
    private VideoService videoService;

    @PostMapping("add")
    public Object create(@RequestBody Video video, List<VideoLink> links) {
        return videoService.create(video, links);
    }

    @DeleteMapping("del-all")
    public void removeAll() {
        videoService.removeAll();
    }
}
