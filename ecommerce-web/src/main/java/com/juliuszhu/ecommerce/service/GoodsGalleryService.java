package com.juliuszhu.ecommerce.service;

import com.juliuszhu.ecommerce.domain.entity.GoodsGallery;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * date: 2020/12/25
 * time: 12:21
 *
 * @author:julius.zhu
 * @describe:商品顶部轮播图service
 */
public interface GoodsGalleryService {
    /**
     * 获取商品详细信息首页轮播图
     *
     * @param goodsId 商品id
     * @return
     */
    List<GoodsGallery> getGallery(Integer goodsId);
}
