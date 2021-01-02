package com.juliuszhu.ecommerce.web;

import com.juliuszhu.ecommerce.domain.entity.CartList;
import com.juliuszhu.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
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
    private final CartService cartService;



    @Autowired
    public CartListController(CartService cartService  ) {
        this.cartService = cartService;

    }

    /**
     * 获取用户购物车数量
     *
     * @return 购物车商品数量
     */
    @PutMapping("goodsCount")
    public Map<String, Integer> getCartGoodsCount(HttpServletRequest request) {

        return cartService.getCartGoodsCount(null);
    }

    /**
     * 获取购物车数据
     *
     * @return
     */
    @GetMapping("index")
    public Map<String, Object> getCartList(HttpServletRequest request) {
        return cartService.getCartList(null);
    }

    /**
     * 添加商品到购物车
     *
     * @param cartList 商品id，数量
     * @return
     */
    @PostMapping("add")
    public Map<String, Object> addCart(@RequestBody CartList cartList, HttpServletRequest request) {
//        cartList.setUsername(username);
        cartService.addCart(cartList);
        return cartService.getCartList(cartList.getUsername());
    }

    /**
     * 购物车商品数量发生改变
     *
     * @param cartList
     * @return
     */
    @PutMapping("update")
    public Map<String, Object> cartUpdate(@RequestBody CartList cartList,HttpServletRequest request) {
//        cartList.setUsername(username);
        cartService.addCart(cartList);
        return cartService.getCartList(cartList.getUsername());
    }

    /**
     * 购物车商品复选框发生改变
     *
     * @param cartList
     * @return
     */
    @PutMapping("checked")
    public Map<String, Object> cartCheckedChange(@RequestBody CartList cartList,HttpServletRequest request) {
//        cartList.setUsername(username);
        cartService.addCart(cartList);
        return cartService.getCartList(cartList.getUsername());
    }
}
