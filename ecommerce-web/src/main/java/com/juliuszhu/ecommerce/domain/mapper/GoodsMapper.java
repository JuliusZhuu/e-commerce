package com.juliuszhu.ecommerce.domain.mapper;

import com.juliuszhu.ecommerce.domain.entity.Goods;
import com.juliuszhu.ecommerce.domain.entity.GoodsSelectCondition;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * date: 2020/12/24
 * time: 20:56
 *
 * @author:julius.zhu
 * @describe: 商品信息mapper
 */
public interface GoodsMapper {


    /**
     * 列出符合条件的商品信息
     *
     * @param condition 条件对象
     * @return
     */
    List<Goods> listGoods(GoodsSelectCondition condition);

    /**
     * 列出符合条件的商品名
     *
     * @param keyword 商品名
     * @return
     */
    List<String> getGoodsNames(String keyword);

    /**
     * 查询单个商品的详细信息
     *
     * @param id 商品id
     * @return 商品详细信息
     */
    @Select("select * from goods where id=#{id}")
    Goods getGoodsInfo(Integer id);

    /**
     * 根据商品id查询单个商品信息
     *
     * @param goodsId 商品id
     * @return
     */
    @Select("select * from goods where goodsId=#{goodsId}")
    Goods getGoodsDetailByGoodsId(Integer goodsId);
}
