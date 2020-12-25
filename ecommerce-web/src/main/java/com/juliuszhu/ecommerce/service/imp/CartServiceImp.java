package com.juliuszhu.ecommerce.service.imp;

import com.juliuszhu.ecommerce.domain.entity.CartList;
import com.juliuszhu.ecommerce.domain.entity.Goods;
import com.juliuszhu.ecommerce.domain.mapper.CartMapper;
import com.juliuszhu.ecommerce.service.CartService;
import com.juliuszhu.ecommerce.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * date: 2020/12/25
 * time: 16:04
 *
 * @author:julius.zhu
 * @describe:
 */
@Service
public class CartServiceImp implements CartService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private GoodsService goodsService;

    @Override
    public Map<String, Integer> getCartGoodsCount(String username) {
        Integer count = cartMapper.getCartGoodsCount(username);
        Map<String, Integer> goodsCount = new HashMap<>();
        goodsCount.put("goodsCount", count);
        return goodsCount;
    }

    @Override
    public Map<String, Object> getCartList(String username) {
        List<CartList> cartLists = cartMapper.getCartList(username);
        Map<String, Object> map = new HashMap<>();
        map.put("cartList", cartLists);
        //计算价格相关
        CartList cartList = new CartList();
        //获取购物车商品总数量
        cartList.setGoodsCount(cartMapper.goodsCount(username));
        //计算购物车商品总价格
        cartList.setGoodsAmount(cartMapper.getGoodsAmount(username));
        map.put("cartTotal", cartList);
        return map;
    }

    @Override
    public void addCart(CartList cartList) {
        //存在则直接更新
        Integer count = cartMapper.isExistsCartGoods(cartList);
        if (count > 0) {
            CartList cartGoods = cartMapper.getCartListByGoodsId(cartList);
            //更新下数量信息
            cartList.setGoodsNumber(cartList.getGoodsNumber() + cartGoods.getGoodsNumber());
            cartMapper.updateCartGoods(cartList);
        } else {
            //查询商品信息
            Goods goods = goodsService.getGoodsDetailByGoodsId(cartList.getGoodsId());
            //若是存在则直接更新
            cartList.setGoodsName(goods.getName());
            cartList.setRetailPrice(goods.getRetailPrice());
            cartList.setListPicUrl(goods.getListPicUrl());
            cartList.setGoodsSn(goods.getGoodsSn());
            cartMapper.addCart(cartList);
        }
    }

    @Override
    public void cartUpdate(CartList cartList) {
        //全选和全不选
        if (cartList.getGoodsId() == null) {
            cartMapper.cartUpdateBatch(cartList.getIsChecked(),
                    cartList.getUsername(), cartList.getGoodsIds());
        } else {
            cartMapper.cartUpdate(cartList);
        }
    }
}
