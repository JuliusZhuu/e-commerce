package com.juliuszhu.ecommerce.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * date: 2020/12/23
 * time: 23:01
 *
 * @author:julius.zhu
 * @describe:品牌实体类
 */
@Setter
@Getter
public class Brand extends BaseEntity {

    /**
     * 名称
     */
    private String name;
    /**
     * 简单描述
     */
    private String simpleDesc;
    /**
     * 图片地址
     */
    private String picUrl;
    /**
     * 是否显示
     */
    private Integer isShow;
    /**
     * 价格
     */
    private BigDecimal floorPrice;
    /**
     * 是否是新品牌
     */
    private String isNew;

}
