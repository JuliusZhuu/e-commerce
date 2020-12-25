package com.juliuszhu.ecommerce.service;

import com.juliuszhu.ecommerce.domain.entity.Goods;
import com.juliuszhu.ecommerce.domain.entity.GoodsSelectCondition;

import java.util.List;
import java.util.Map;

/**
 * date: 2020/12/24
 * time: 20:53
 *
 * @author:julius.zhu
 * @describe: 商品信息service
 */
public interface GoodsService {
    /**
     * 给定条件列出商品信息
     *
     * @param condition 条件
     * @return
     */
    Map<String, Object> listGoods(GoodsSelectCondition condition);

    /**
     * 获取所有的商品名称
     *
     * @param keyword 商品名称
     * @return 商品名称集合
     */
    List<String> getGoodsNames(String keyword);

    /**
     * 查询单个商品信息
     *
     * @param id 商品id
     * @return 商品信息对象
     */
    Map<String, Object> getGoodsDetail(Integer id);

    /**
     * 根据商品id查询单个商品信息
     *
     * @param goodsId 商品id
     * @return
     */
    Goods getGoodsDetailByGoodsId(Integer goodsId);

    /**
     * 获取相关商品信息
     *
     * @param name 商品信息名称
     * @return 相关商品信息
     */
    Map<String, Object> getAboutGoods(String name);
}
