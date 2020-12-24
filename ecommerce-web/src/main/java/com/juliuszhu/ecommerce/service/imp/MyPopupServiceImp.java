package com.juliuszhu.ecommerce.service.imp;

import com.juliuszhu.ecommerce.domain.entity.HotKeywordList;
import com.juliuszhu.ecommerce.service.HistoryKeywordListService;
import com.juliuszhu.ecommerce.service.HotKeywordListService;
import com.juliuszhu.ecommerce.service.MyPopupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * date: 2020/12/24
 * time: 22:50
 *
 * @author:julius.zhu
 * @describe:
 */
@Service
public class MyPopupServiceImp implements MyPopupService {
    @Autowired
    private HistoryKeywordListService historyKeywordListService;
    @Autowired
    private HotKeywordListService hotKeywordListService;

    @Override
    public Map<String, Object> getIndex(String username) {
        //查询默认关键词
        String defaultKeyword = hotKeywordListService.getDefaultKeyword(1);
        //查询历史搜索记录
        List<String> historyKeyword = historyKeywordListService.getHistoryKeyWord(username);
        //查询热门
        List<HotKeywordList> hotKeyword = hotKeywordListService.getHotKeyword();
        Map<String, Object> map = new HashMap<>();
        map.put("defaultKeyword", defaultKeyword);
        map.put("historyKeywordList", historyKeyword);
        map.put("hotKeywordList", hotKeyword);
        return map;
    }
}
