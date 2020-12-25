package com.juliuszhu.ecommerce.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

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
     * 商品主图
     */
    private String listPicUrl;
    /**
     * 商品价格
     */
    private BigDecimal retailPrice = new BigDecimal("0.00");
    /**
     * 类目id
     */
    private Integer categoryId;
    /**
     * 品牌id
     */
    private Integer brandId;
    /**
     * 商品条形码
     */
    private String goodsSn;
    /**
     * 商品库存
     */
    private Integer goodsNumber = 0;
    /**
     * 简单描述
     */
    private String goodsBrief;
    /**
     * 细节描述图，多张图片以;分隔
     */
    private String goodsDesc;
    /**
     * 是否在售
     */
    private Integer isOnSale;
    /**
     * 添加时间
     */
    private Date addTime = new Date();
    /**
     * 是否删除
     */
    private Integer isDelete;
    /**
     * 单位,例如 件
     */
    private String goodsUnit;
    /**
     * 是否热门
     */
    private Integer isHot;
    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 去重方法,认为GoodsId一致则为一个产品,事实也该如此
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Objects.equals(goodsId, goods.goodsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", listPicUrl='" + listPicUrl + '\'' +
                ", retailPrice=" + retailPrice +
                ", categoryId=" + categoryId +
                ", brandId=" + brandId +
                ", goodsSn='" + goodsSn + '\'' +
                ", goodsNumber=" + goodsNumber +
                ", goodsBrief='" + goodsBrief + '\'' +
                ", goodsDesc='" + goodsDesc + '\'' +
                ", isOnSale=" + isOnSale +
                ", addTime=" + addTime +
                ", isDelete=" + isDelete +
                ", goodsUnit='" + goodsUnit + '\'' +
                ", isHot=" + isHot +
                ", goodsId=" + goodsId +
                '}';
    }

}
