package com.juliuszhu.ecommerce.domain.mapper;

import com.juliuszhu.ecommerce.domain.entity.GoodsGallery;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * date: 2020/12/25
 * time: 12:19
 *
 * @author:julius.zhu
 * @describe: 商品信息顶部轮播图mapper
 */
public interface GoodsGalleryMapper {
    @Select("select * from  goods_gallery where goodsId=#{goodsId}")
    List<GoodsGallery> getGallery(Integer goodsId);
}
