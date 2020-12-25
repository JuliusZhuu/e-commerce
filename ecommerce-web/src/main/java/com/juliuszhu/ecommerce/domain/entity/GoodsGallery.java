package com.juliuszhu.ecommerce.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * date: 2020/12/25
 * time: 12:15
 *
 * @author:julius.zhu
 * @describe:商品信息顶部轮播图
 */
@Setter
@Getter
public class GoodsGallery extends BaseEntity {
    /**
     * 商品id
     */
    private Integer goodsId;
    /**
     * 图片地址
     */
    private String imgUrl;
    /**
     * 描述
     */
    private String imgDesc;

    @Override
    public String toString() {
        return "GoodsGallery{" +
                "goodsId=" + goodsId +
                ", imgUrl='" + imgUrl + '\'' +
                ", imgDesc='" + imgDesc + '\'' +
                '}';
    }
}
