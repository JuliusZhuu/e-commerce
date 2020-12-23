package com.juliuszhu.ecommerce.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * date: 2020/12/23
 * time: 22:00
 *
 * @author:julius.zhu
 * @describe: 轮播图实体类
 */
@Setter
@Getter
public class Banner extends BaseEntity {

    /**
     * 名称
     */
    private String name;
    /**
     * 连接
     */
    private String link;
    /**
     * 图片地址
     */
    private String imageUrl;
    /**
     * 内容
     */
    private String content;
    /**
     * 是否开启该活动,1开启0未开启
     */
    private Integer enabled;

    /**
     * 结束时间
     */
    private Date end_time;
}
