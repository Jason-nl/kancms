package cn.kancms.model.management.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_video")
public class Video implements Serializable {
    private static final long serialVersionUID = -4098522803696333715L;
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    /**
     * video 名称
     */
    private String name;
    /**
     * video 主演（无主演-动漫｜综艺）
     */
    private String starring;
    /**
     * video type
     */
    private String type;
    /**
     * video 时长(正片｜空｜共n集｜第2021-12-10期)
     */
    private String duration;
    /**
     * video 地区
     */
    private String region;
    /**
     * video 上映时间
     */
    @TableField(value = "release_at")
    private String releaseAt;
    /**
     * video 更新时间
     */
    @TableField(value = "update_at")
    private String updateAt;
    /**
     * video 剧情介绍
     */
    private String synopsis;
    /**
     * video 来源站点
     */
    private String source;
}

