package com.juliuszhu.ecommerce.service;

import com.juliuszhu.ecommerce.domain.entity.GoodsIssue;

import java.util.List;

/**
 * date: 2020/12/25
 * time: 12:21
 *
 * @author:julius.zhu
 * @describe:商品常见问题service
 */
public interface GoodsIssueService {
    /**
     * 获取商品详细信息的问题
     * @param goodsId 商品id
     * @return
     */
    List<GoodsIssue> getIssue(Integer goodsId);
}
