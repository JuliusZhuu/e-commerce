package com.juliuszhu.ecommerce.domain.mapper;

import com.juliuszhu.ecommerce.domain.entity.HotKeywordList;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * date: 2020/12/24
 * time: 22:59
 *
 * @author:julius.zhu
 * @describe:
 */
public interface HotKeywordListMapper {

    @Select("select * from hot_keyword_list  ")
    List<HotKeywordList> getHotKeyword();

    @Select("select keyword from hot_keyword_list where isHot=1")
    String getDefaultKeyword(Integer isHot);
}
