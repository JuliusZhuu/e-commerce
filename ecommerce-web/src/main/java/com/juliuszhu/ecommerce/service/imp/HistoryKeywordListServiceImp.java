package com.juliuszhu.ecommerce.service.imp;

import com.juliuszhu.ecommerce.domain.entity.HotKeywordList;
import com.juliuszhu.ecommerce.domain.mapper.HistoryKeywordListMapper;
import com.juliuszhu.ecommerce.service.HistoryKeywordListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * date: 2020/12/24
 * time: 22:30
 *
 * @author:julius.zhu
 * @describe:
 */
@Service
public class HistoryKeywordListServiceImp implements HistoryKeywordListService {
    @Autowired
    private HistoryKeywordListMapper mapper;

    @Override
    public List<String> getHistoryKeyWord(String username) {
        return mapper.getHistoryKeyWord(username);
    }
}
