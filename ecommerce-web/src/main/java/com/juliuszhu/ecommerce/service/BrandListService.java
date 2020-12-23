package com.juliuszhu.ecommerce.service;

import com.juliuszhu.ecommerce.domain.entity.Brand;

import java.util.List;

/**
 * date: 2020/12/23
 * time: 22:59
 *
 * @author:julius.zhu
 * @describe: 首页品牌service
 */
public interface BrandListService {
    /**
     * 获取首页品牌信息
     * @return
     */
    List<Brand> getHomeBrand();
}
