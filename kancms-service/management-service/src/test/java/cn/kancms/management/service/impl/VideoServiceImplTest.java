package cn.kancms.management.service.impl;

import cn.kancms.management.service.VideoService;
import cn.kancms.model.management.pojo.Video;
import cn.kancms.model.management.pojo.VideoLink;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class VideoServiceImplTest {
    @Resource
    private VideoService videoService;

    private List<VideoLink> links;
    private Video video;

    @BeforeEach
    void setUp() {
        video = new Video();
        video.setName("埃博拉前线");
        video.setStarring("罗晋,毛晓彤,许");
        video.setType("国产剧");
        video.setDuration("更新至11集");
        video.setRegion("内地");
        video.setReleaseAt("2021");
        video.setUpdateAt("2021-12-14 21:01:01");
        video.setSynopsis("该剧以2014年中国援非医疗队抗击“埃博拉病毒“的事迹为原型，讲述了病毒学家郑书鹏和他所在的中国援非医疗队与埃博拉病毒展开艰苦卓绝的战斗，最终成功遏制病毒蔓延，圆满完成援非医疗任务的故事。");
        video.setSource("腾讯视频");

        links = List.of(
                new VideoLink("https://v.qq.com/x/cover/mzc00200ijghodp/o004180owhw.html"),
                new VideoLink("https://v.qq.com/x/cover/mzc00200ijghodp/j0041z5dtjy.html"),
                new VideoLink("https://v.qq.com/x/cover/mzc00200ijghodp/d0041i5urcm.html"),
                new VideoLink("https://v.qq.com/x/cover/mzc00200ijghodp/u0041318cpt.html")
        );

//,
//                new VideoLink("https://v.qq.com/x/cover/mzc00200ijghodp/u0041318cpt.html")
    }

    @Test
    void create() {
        Map result = (Map) videoService.create(video, links);
        assertThat(result.get("id").toString().length()).isEqualTo(19);
    }

//    @AfterEach
//    void tearDown() {
//        videoService.removeAll();
//    }
}