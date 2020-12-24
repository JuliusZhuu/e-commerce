package com.juliuszhu.ecommerce.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * date: 2020/12/23
 * time: 23:20
 *
 * @author:julius.zhu
 * @describe:商品实体类
 */
@Setter
@Getter
public class Goods extends BaseEntity {

    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品图片
     */
    private String listPicUrl;
    /**
     * 商品价格
     */
    private BigDecimal retailPrice;
}
