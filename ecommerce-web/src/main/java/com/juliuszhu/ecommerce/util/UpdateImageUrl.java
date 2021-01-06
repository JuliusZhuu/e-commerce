package com.juliuszhu.ecommerce.util;

import com.juliuszhu.ecommerce.domain.entity.Banner;
import com.juliuszhu.ecommerce.domain.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * date: 2021/1/6
 * time: 16:40
 *
 * @author:julius.zhu
 * @describe:更新图片地址
 */
@Component
public class UpdateImageUrl {
    private final BannerMapper bannerMapper;

    public UpdateImageUrl(BannerMapper bannerMapper) {
        this.bannerMapper = bannerMapper;
    }

    /**
     * 替换图片的url地址
     *
     * @param url    图片本地的url地址
     * @param oldUrl 旧的ip地址
     * @param newUrl 新的ip地址
     * @return 替换好的字符串
     */
    private String replaceUrl(String url, String oldUrl, String newUrl) {
        return url.replace(oldUrl, newUrl);
    }

    /**
     * 获取所有替换之后的图片地址(带图片id)
     * 若是图片较少建议分页替换
     *
     * @param oldUrl 旧的ip
     * @param newUrl 新的ip
     * @return 替换成功之后的图片地址
     */
    private List<Banner> getBanners(String oldUrl, String newUrl) {
        List<Banner> newBanners = new ArrayList<>();
        List<Banner> homeSlideShow = bannerMapper.getHomeSlideShow();
        homeSlideShow.forEach(item -> {
            Integer id = item.getId();
            String imageUrl = item.getImageUrl();
            String s = replaceUrl(imageUrl, oldUrl, newUrl);
            Banner banner = new Banner();
            banner.setId(id);
            banner.setImageUrl(s);
            newBanners.add(banner);
        });
        return newBanners;
    }

    /**
     * 更新图片的url地址
     *
     * @param oldUrl 旧的url
     * @param newUrl 新的url
     */
    public void updateUrl(String oldUrl, String newUrl) {
        List<Banner> banners = getBanners(oldUrl, newUrl);
        banners.forEach(item -> {
            bannerMapper.updateById(item);
        });
    }
}
