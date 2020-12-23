package com.juliuszhu.ecommerce.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * date: 2020/12/23
 * time: 22:44
 *
 * @author:julius.zhu
 * @describe:频道实体类
 */
@Setter
@Getter
public class Channel extends BaseEntity {
    /**
     * 名称
     */
    private String name;

    /**
     * 路由地址
     */
    private String url;
    /**
     * 图片地址
     */
    private String iconUrl;
}
