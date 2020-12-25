package com.juliuszhu.ecommerce.service.imp;

import com.juliuszhu.ecommerce.domain.entity.GoodsAttribute;
import com.juliuszhu.ecommerce.domain.mapper.GoodsAttributeMapper;
import com.juliuszhu.ecommerce.service.GoodsAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * date: 2020/12/25
 * time: 12:22
 *
 * @author:julius.zhu
 * @describe:
 */
@Service
public class GoodsAttributeServiceImp implements GoodsAttributeService {
    @Autowired
    private GoodsAttributeMapper goodsAttributeMapper;

    @Override
    public List<GoodsAttribute> getAttribute(Integer goodsId) {
        return goodsAttributeMapper.getAttribute(goodsId);
    }
}
