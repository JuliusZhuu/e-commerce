package com.juliuszhu.ecommerce.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juliuszhu.ecommerce.domain.entity.HistoryKeywordList;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * date: 2020/12/24
 * time: 22:30
 *
 * @author:julius.zhu
 * @describe:
 */
public interface HistoryKeywordListMapper {
    @Select("select name  from history_keyword_list ")
    List<String> getHistoryKeyWord(String username);

}
