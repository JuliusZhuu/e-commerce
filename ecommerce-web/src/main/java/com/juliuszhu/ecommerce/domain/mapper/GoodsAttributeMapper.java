package com.juliuszhu.ecommerce.domain.mapper;

import com.juliuszhu.ecommerce.domain.entity.GoodsAttribute;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * date: 2020/12/25
 * time: 12:19
 *
 * @author:julius.zhu
 * @describe:商品属性mapper
 */
public interface GoodsAttributeMapper {
    @Select("select * from goods_attribute where goodsId=#{goodsId} ")
    List<GoodsAttribute> getAttribute(Integer goodsId);
}
