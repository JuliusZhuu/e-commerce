package com.juliuszhu.ecommerce.service;

import com.juliuszhu.ecommerce.domain.entity.Banner;

import java.util.List;
import java.util.Map;

/**
 * date: 2020/12/23
 * time: 22:06
 *
 * @author:julius.zhu
 * @describe: 首页轮播图service
 */
public interface BannerService {
    /**
     * 获取首页轮播图信息
     *
     * @return 首页轮播图信息
     */
    List<Banner> getHomeSlideShow();
}
