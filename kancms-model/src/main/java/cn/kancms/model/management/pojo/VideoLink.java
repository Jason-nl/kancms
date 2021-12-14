package cn.kancms.model.management.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@TableName("tb_video_link")
public class VideoLink {
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;
    private Long VideoId;
    /**
     * video URL
     */
    private String url;

    public VideoLink(String url) {
        this.url = url;
    }
}
