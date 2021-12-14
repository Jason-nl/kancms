create table `tb_video` (
    `id` int(50) not null comment '视频ID',
    `name` varchar(100) not null comment '视频名称',
    `starring` varchar(100) null comment '主演',
    `type` varchar(50) not null comment '视频类型',
    `duration` varchar(10) null comment '时长',
    `region` varchar(50) not null comment '地区',
    `release` varchar(50) not null comment '上映时间',
    `update_at` varchar(50) not null comment '更新时间',
    `synopsis` varchar(255) not null comment '剧情介绍',
    `source` varchar(50) not null comment '站点来源',
    primary key(`id`)
) comment '视频表';

create table `tb_video_link` (
    `id` int(50) not null comment '视频ID',
    `url` varchar(255) not null comment '视频链接'
) comment '视频链接表';

-- private Integer id;
--
--     /**
--      * video 名称
--      */
--     private String name;
--     /**
--      * video 主演（无主演-动漫｜综艺）
--      */
--     private String starring;
--     /**
--      * video type
--      */
--     private String type;
--     /**
--      * video 时长(正片｜空｜共n集｜第2021-12-10期)
--      */
--     private Integer duration;
--     /**
--      * video 地区
--      */
--     private String region;
--     /**
--      * video 上映时间
--      */
--     private String release;
--     /**
--      * video 更新时间
--      */
--     @TableField(value = "update_at")
--     private String updateAt;
--     /**
--      * video 剧情介绍
--      */
--     private String synopsis;
--     /**
--      * video 来源站点
--      */
--     private String source;