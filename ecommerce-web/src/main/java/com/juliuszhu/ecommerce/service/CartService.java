package com.juliuszhu.ecommerce.service;

import com.juliuszhu.ecommerce.domain.entity.CartList;

import java.util.Map;

/**
 * date: 2020/12/25
 * time: 16:04
 *
 * @author:julius.zhu
 * @describe:购物车Service
 */
public interface CartService {
    /**
     * 获取用户购物车商品数量
     *
     * @param username 用户名
     * @return 购物车商品数量
     */
    Map<String, Integer> getCartGoodsCount(String username);

    /**
     * 获取购物车数据
     *
     * @param username
     * @return
     */
    Map<String, Object> getCartList(String username);

    /**
     * 添加商品到购物车
     *
     * @param cartList
     */
    void addCart(CartList cartList);

    /**
     * 购物车商品数量发生改变
     *
     * @param cartList
     */
    void cartUpdate(CartList cartList);
}
