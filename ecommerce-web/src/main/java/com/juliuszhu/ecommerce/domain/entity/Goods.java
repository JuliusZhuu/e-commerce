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
//    {
//        "id": 1023003,
//            "name": "100年传世珐琅锅 全家系列",
//            "list_pic_url": "http://yanxuan.nosdn.127.net/c39d54c06a71b4b61b6092a0d31f2335.png",
//            "retail_price": 398
//    },
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
