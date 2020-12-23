package com.juliuszhu.ecommerce.service.imp;

import com.juliuszhu.ecommerce.domain.entity.Banner;
import com.juliuszhu.ecommerce.domain.mapper.BannerMapper;
import com.juliuszhu.ecommerce.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * date: 2020/12/23
 * time: 22:06
 *
 * @author:julius.zhu
 * @describe:
 */
@Service
public class BannerServiceImp implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public List<Banner> getHomeSlideShow() {
        return bannerMapper.getHomeSlideShow();
    }
}
