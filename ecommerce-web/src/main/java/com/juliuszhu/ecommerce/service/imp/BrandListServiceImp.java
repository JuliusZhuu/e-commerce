package com.juliuszhu.ecommerce.service.imp;

import com.juliuszhu.ecommerce.domain.entity.Brand;
import com.juliuszhu.ecommerce.domain.mapper.BrandListMapper;
import com.juliuszhu.ecommerce.service.BrandListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * date: 2020/12/23
 * time: 23:00
 *
 * @author:julius.zhu
 * @describe:
 */
@Service
public class BrandListServiceImp implements BrandListService {
    @Autowired
    private BrandListMapper brandListMapper;

    @Override
    public List<Brand> getHomeBrand() {
        return brandListMapper.getBrand();
    }
}
