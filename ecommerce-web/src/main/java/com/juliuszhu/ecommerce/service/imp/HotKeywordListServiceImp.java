package com.juliuszhu.ecommerce.service.imp;

import com.juliuszhu.ecommerce.domain.entity.HotKeywordList;
import com.juliuszhu.ecommerce.domain.mapper.HotKeywordListMapper;
import com.juliuszhu.ecommerce.service.HotKeywordListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * date: 2020/12/24
 * time: 22:53
 *
 * @author:julius.zhu
 * @describe:
 */
@Service
public class HotKeywordListServiceImp implements HotKeywordListService {

    @Autowired
    private HotKeywordListMapper mapper;
    @Override
    public List<HotKeywordList> getHotKeyword() {
        return mapper.getHotKeyword();
    }

    @Override
    public String getDefaultKeyword(Integer isHot) {
        return mapper.getDefaultKeyword(isHot);
    }

}
