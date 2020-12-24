package com.juliuszhu.ecommerce;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.juliuszhu.ecommerce.service.BannerService;
import com.juliuszhu.ecommerce.service.BrandListService;
import com.juliuszhu.ecommerce.service.ChannelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class EcommerceWebApplicationTests {
    @Autowired
    private BannerService bannerService;
    @Autowired
    private ChannelService channelService;

    @Autowired
    private BrandListService brandListService;

    EcommerceWebApplicationTests() {
    }

    @Test
    void contextLoads()   {


    }

}
