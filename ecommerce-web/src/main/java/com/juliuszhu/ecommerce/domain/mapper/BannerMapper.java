package com.juliuszhu.ecommerce.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.juliuszhu.ecommerce.domain.entity.Banner;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * date: 2020/12/23
 * time: 22:05
 *
 * @author:julius.zhu
 * @describe:首页轮播图mapper
 */
@Repository
public interface BannerMapper extends BaseMapper<Banner> {
    /**
     * 获取所有首页轮播图信息
     *
     * @return
     */

    @Select("select  *  from  banner ")
    List<Banner> getHomeSlideShow();

    @Update("update banner set imageUrl=#{imageUrl} where id=#{id}")
    int updateById(Banner banner);
}
