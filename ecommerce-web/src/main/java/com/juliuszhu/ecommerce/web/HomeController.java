package com.juliuszhu.ecommerce.web;

import com.juliuszhu.ecommerce.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * date: 2020/12/23
 * time: 21:55
 *
 * @author:julius.zhu
 * @describe: 前端首页controller
 */
@RestController
@RequestMapping("index")
public class HomeController {
    @Autowired
    private HomeService homeService;

    /**
     * 获取首页信息,包括轮播图,频道，专题
     *
     * @return 轮播图信息
     */
    @GetMapping("index")
    public Map<String, Object> getHomeIndex() {
        return homeService.getHomeIndex();
    }

}
