package com.juliuszhu.ecommerce.service.imp;

import com.juliuszhu.ecommerce.domain.entity.Goods;

import com.juliuszhu.ecommerce.domain.entity.GoodsSelectCondition;
import com.juliuszhu.ecommerce.domain.mapper.GoodsMapper;
import com.juliuszhu.ecommerce.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * date: 2020/12/24
 * time: 20:54
 *
 * @author:julius.zhu
 * @describe:
 */
@Service
public class GoodsServiceImp implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Map<String, Object> listGoods(GoodsSelectCondition condition) {
        List<Goods> goods = goodsMapper.listGoods(condition);
        Map<String, Object> goodsList = new HashMap<>();
        goodsList.put("goodsList", goods);
        return goodsList;
    }
}
