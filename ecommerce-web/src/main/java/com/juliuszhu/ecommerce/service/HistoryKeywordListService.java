package com.juliuszhu.ecommerce.service;

import com.juliuszhu.ecommerce.domain.entity.HotKeywordList;

import java.util.List;

/**
 * date: 2020/12/24
 * time: 22:29
 *
 * @author:julius.zhu
 * @describe: 历史关键词搜索service
 */
public interface HistoryKeywordListService {

    List<String> getHistoryKeyWord(String username);
}
