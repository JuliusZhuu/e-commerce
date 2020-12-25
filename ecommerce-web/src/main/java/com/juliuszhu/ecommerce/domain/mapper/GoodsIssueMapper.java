package com.juliuszhu.ecommerce.domain.mapper;

import com.juliuszhu.ecommerce.domain.entity.GoodsIssue;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * date: 2020/12/25
 * time: 12:19
 *
 * @author:julius.zhu
 * @describe: 商品常见问题mapper
 */
public interface GoodsIssueMapper {
    @Select("select * from goods_issue where goodsId=#{goodsId}")
    List<GoodsIssue> getIssue(Integer goodsId);
}
