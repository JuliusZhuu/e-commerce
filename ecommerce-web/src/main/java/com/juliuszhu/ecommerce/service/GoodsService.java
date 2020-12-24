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

    Map<String, Object> listGoods(GoodsSelectCondition condition);
}
