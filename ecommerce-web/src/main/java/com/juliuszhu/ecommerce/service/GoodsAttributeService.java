package com.juliuszhu.ecommerce.service;

import com.juliuszhu.ecommerce.domain.entity.GoodsAttribute;

import java.util.List;

/**
 * date: 2020/12/25
 * time: 12:20
 *
 * @author:julius.zhu
 * @describe:商品属性service
 */
public interface GoodsAttributeService {
    /**
     * 获取商品详细信息属性
     * @param goodsId 商品id
     * @return 商品详细信息属性集合
     */
    List<GoodsAttribute> getAttribute(Integer goodsId);
}
