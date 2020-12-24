package com.juliuszhu.ecommerce.web;

import com.juliuszhu.ecommerce.domain.entity.Goods;

import com.juliuszhu.ecommerce.domain.entity.GoodsSelectCondition;
import com.juliuszhu.ecommerce.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * date: 2020/12/23
 * time: 23:29
 *
 * @author:julius.zhu
 * @describe:商品信息controller
 */
@RestController
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /**
     * 查询商品信息
     *
     * @param keyword    关键词
     * @param page       当前页
     * @param size       每页显示记录数
     * @param order      价格排序方式,desc降序asc升序
     * @param categoryId 商品类别id
     * @return 符合条件的商品信息对象
     */
    @GetMapping("list")
    public Map<String, Object> listGoods(@RequestParam("keyword") String keyword,
                                         @RequestParam(value = "page", required = false) Integer page,
                                         @RequestParam(value = "size", required = false) Integer size,
                                         @RequestParam(value = "order", required = false) String order,
                                         @RequestParam(value = "categoryId", required = false) Integer categoryId) {
        GoodsSelectCondition condition = new GoodsSelectCondition();
        if (page != null) {
            condition.setPage(page);
        }
        if (size != null) {
            condition.setSize(size);
        }
        if (order != null) {
            condition.setOrder(order);
        }
        if (categoryId != null) {
            condition.setCategoryId(categoryId);
        }
        condition.setKeyword(keyword);
        return goodsService.listGoods(condition);
    }
}
