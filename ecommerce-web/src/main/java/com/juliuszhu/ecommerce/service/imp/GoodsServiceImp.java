package com.juliuszhu.ecommerce.service.imp;

import com.juliuszhu.ecommerce.domain.entity.Goods;

import com.juliuszhu.ecommerce.domain.entity.GoodsSelectCondition;
import com.juliuszhu.ecommerce.domain.mapper.GoodsMapper;
import com.juliuszhu.ecommerce.service.GoodsAttributeService;
import com.juliuszhu.ecommerce.service.GoodsGalleryService;
import com.juliuszhu.ecommerce.service.GoodsIssueService;
import com.juliuszhu.ecommerce.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    @Autowired
    private GoodsGalleryService galleryService;
    @Autowired
    private GoodsAttributeService attributeService;
    @Autowired
    private GoodsIssueService issueService;

    @Override
    public Map<String, Object> listGoods(GoodsSelectCondition condition) {
        List<Goods> goods = goodsMapper.listGoods(condition);
        Map<String, Object> goodsList = new HashMap<>();
        //查询到商品信息
        goodsList.put("goodsList", goods);
        //分类信息,后续从数据库中查询
        Map<String, Integer> filterCategory = new HashMap<>();
        goodsList.put("filterCategory", filterCategory);
        return goodsList;
    }

    @Override
    public List<String> getGoodsNames(String keyword) {
        return goodsMapper.getGoodsNames(keyword);
    }

    @Override
    public Map<String, Object> getGoodsDetail(Integer id) {
        //查询商品详细信息
        Goods goodsInfo = goodsMapper.getGoodsInfo(id);
        Integer goodsId = goodsInfo.getGoodsId();
        Map<String, Object> map = new HashMap<>();
        map.put("info", goodsInfo);
        //查询商品详细信息首页轮播图
        map.put("gallery", galleryService.getGallery(goodsId));
        //查询商品详细信息属性
        map.put("attribute", attributeService.getAttribute(goodsId));
        //获取常见问题
        map.put("issue", issueService.getIssue(goodsId));
        return map;
    }

    @Override
    public Goods getGoodsDetailByGoodsId(Integer goodsId) {
        return goodsMapper.getGoodsDetailByGoodsId(goodsId);
    }

    @Override
    public Map<String, Object> getAboutGoods(String name) {
        GoodsSelectCondition condition = new GoodsSelectCondition();
        Set<Goods> goods = new LinkedHashSet<>();
        //拆分成多个单词去搜索,此处的逻辑待优化
        char[] chars = name.toCharArray();
        for (char aChar : chars) {
            condition.setKeyword(aChar + "");
            goods.addAll(goodsMapper.listGoods(condition));
        }
        Map<String, Object> goodsList = new HashMap<>();
        goodsList.put("goodsList", goods);
        return goodsList;
    }
}
