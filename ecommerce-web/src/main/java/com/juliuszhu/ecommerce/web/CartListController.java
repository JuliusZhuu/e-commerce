package com.juliuszhu.ecommerce.web;

import com.juliuszhu.ecommerce.domain.entity.CartList;
import com.juliuszhu.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * date: 2020/12/25
 * time: 16:00
 *
 * @author:julius.zhu
 * @describe: 购物车Controller
 */
@RestController
@RequestMapping("cart")
public class CartListController {

    @Autowired
    private CartService cartService;

    /**
     * 获取用户购物车数量
     *
     * @return 购物车商品数量
     */
    @PutMapping("goodsCount")
    public Map<String, Integer> getCartGoodsCount() {
        //请求时候应在请求头中携带token,根据token中缓存中获取到用户信息,生效了则重新登录等
        //暂时开发只设置一个固定的
        String username = "julius";
        return cartService.getCartGoodsCount(username);
    }

    /**
     * 获取购物车数据
     *
     * @return
     */
    @GetMapping("index")
    public Map<String, Object> getCartList() {
        String username = "julius";
        return cartService.getCartList(username);
    }

    /**
     * 添加商品到购物车
     *
     * @param cartList 商品id，数量
     * @return
     */
    @PostMapping("add")
    public Map<String, Object> addCart(@RequestBody CartList cartList) {
        String username = "julius";
        cartList.setUsername(username);
        cartService.addCart(cartList);
        return cartService.getCartList(username);
    }

    /**
     * 购物车商品数量发生改变
     *
     * @param cartList
     * @return
     */
    @PutMapping("update")
    public Map<String, Object> cartUpdate(@RequestBody CartList cartList) {
        String username = "julius";
        cartList.setUsername(username);
        cartService.cartUpdate(cartList);
        return cartService.getCartList(username);
    }

    /**
     * 购物车商品复选框发生改变
     *
     * @param cartList
     * @return
     */
    @PutMapping("checked")
    public Map<String, Object> cartCheckedChange(@RequestBody CartList cartList) {
        String username = "julius";
        cartList.setUsername(username);
        cartService.cartUpdate(cartList);
        return cartService.getCartList(username);
    }
}
