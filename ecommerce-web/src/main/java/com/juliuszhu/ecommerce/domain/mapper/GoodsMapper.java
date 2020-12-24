package com.juliuszhu.ecommerce.domain.mapper;

import com.juliuszhu.ecommerce.domain.entity.Goods;
import com.juliuszhu.ecommerce.domain.entity.GoodsSelectCondition;

import java.util.List;

/**
 * date: 2020/12/24
 * time: 20:56
 *
 * @author:julius.zhu
 * @describe: 商品信息mapper
 */
public interface GoodsMapper {

    List<Goods> listGoods(GoodsSelectCondition condition);
}
