package com.juliuszhu.ecommerce.service;

import com.juliuszhu.ecommerce.domain.entity.HotKeywordList;

import java.util.List;

/**
 * date: 2020/12/24
 * time: 22:53
 *
 * @author:julius.zhu
 * @describe:
 */
public interface HotKeywordListService {

    List<HotKeywordList> getHotKeyword();


    String getDefaultKeyword(Integer isHot);
}
