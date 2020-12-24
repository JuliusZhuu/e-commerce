package com.juliuszhu.ecommerce.service.imp;

import com.juliuszhu.ecommerce.domain.entity.*;
import com.juliuszhu.ecommerce.service.BannerService;
import com.juliuszhu.ecommerce.service.BrandListService;
import com.juliuszhu.ecommerce.service.ChannelService;
import com.juliuszhu.ecommerce.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * date: 2020/12/23
 * time: 22:37
 *
 * @author:julius.zhu
 * @describe:
 */
@Service
public class HomeServiceImp implements HomeService {

    @Autowired
    private BannerService bannerService;
    @Autowired
    private ChannelService channelService;

    @Autowired
    private BrandListService brandListService;

    @Override
    public Map<String, Object>  getHomeIndex() {
        List<Banner> homeSlideShow = bannerService.getHomeSlideShow();
        List<Channel> homeChannel = channelService.getHomeChannel();
        List<Brand> homeBrand = brandListService.getHomeBrand();
        Map<String, Object> map = new HashMap<>();
        //分页数据
        PageInfoEntity page = new PageInfoEntity();
        page.setCount(100);
        page.setCurrentPage(1);
        page.setTotalPages(10);
        page.setPageSize(10);
        map.put("pageInfo", page);
        map.put("banner", homeSlideShow);
        map.put("channel", homeChannel);
        map.put("brandList", homeBrand);
        return map;
    }
}
