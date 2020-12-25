package com.juliuszhu.ecommerce.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * date: 2020/12/25
 * time: 16:35
 *
 * @author:julius.zhu
 * @describe:购物车实体
 */
@Setter
@Getter
public class CartList extends BaseEntity {
    /**
     * 用户名
     */
    private String username;
    /**
     * 商品id
     */
    private Integer goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 折扣价
     */
    private BigDecimal retailPrice;
    /**
     * 市场价
     */
    private String marketPrice;
    /**
     * 商品数量
     */
    private Integer goodsNumber;
    /**
     * 商品主图
     */
    private String listPicUrl;
    /**
     * 是否被选中
     */
    private String isChecked;
    /**
     * 商品条形码
     */
    private String goodsSn;

    /**
     * 购物车商品总数量
     */
    private Integer goodsCount;
    /**
     * 购物车商品总价格
     */
    private BigDecimal goodsAmount;

    /**
     * 专门用于更新多个商品选中状态的goodsIds
     */
    private String[] goodsIds;

    @Override
    public String toString() {
        return "CartList{" +
                "username='" + username + '\'' +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", retailPrice=" + retailPrice +
                ", marketPrice='" + marketPrice + '\'' +
                ", goodsNumber=" + goodsNumber +
                ", listPicUrl='" + listPicUrl + '\'' +
                ", isChecked='" + isChecked + '\'' +
                ", goodsSn='" + goodsSn + '\'' +
                ", goodsCount=" + goodsCount +
                ", goodsAmount=" + goodsAmount +
                ", goodsIds=" + Arrays.toString(goodsIds) +
                '}';
    }
}
