package com.juliuszhu.ecommerce.service;

import java.util.Map;

/**
 * date: 2020/12/23
 * time: 22:37
 *
 * @author:julius.zhu
 * @describe:首页service
 */
public interface HomeService {
    /**
     * 返回首页数据,包括轮播图，频道等信息
     * @return
     */
    Map<String,Object> getHomeIndex();
}
