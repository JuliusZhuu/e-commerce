package com.juliuszhu.ecommerce.domain.mapper;

import com.juliuszhu.ecommerce.domain.entity.Brand;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * date: 2020/12/23
 * time: 23:01
 *
 * @author:julius.zhu
 * @describe:
 */
public interface BrandListMapper {
    @Select("select * from brand")
    List<Brand> getBrand();
}
