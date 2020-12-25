package com.juliuszhu.ecommerce.service.imp;

import com.juliuszhu.ecommerce.domain.entity.GoodsGallery;
import com.juliuszhu.ecommerce.domain.mapper.GoodsGalleryMapper;
import com.juliuszhu.ecommerce.service.GoodsGalleryService;
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
public class GoodsGalleryServiceImp implements GoodsGalleryService {
    @Autowired
    private GoodsGalleryMapper goodsGalleryMapper;
    @Override
    public List<GoodsGallery> getGallery(Integer goodsId) {
        return  goodsGalleryMapper.getGallery(goodsId);
    }
}
