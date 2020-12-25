package com.juliuszhu.ecommerce.web;

import com.juliuszhu.ecommerce.service.GoodsService;
import com.juliuszhu.ecommerce.service.HistoryKeywordListService;
import com.juliuszhu.ecommerce.service.MyPopupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * date: 2020/12/24
 * time: 22:27
 *
 * @author:julius.zhu
 * @describe: 搜索框controller
 */
@RestController
@RequestMapping("search")
public class MyPopupController {

    @Autowired
    private MyPopupService myPopupService;
    @Autowired
    private GoodsService goodsService;

    /**
     * 获取用户的搜索记录
     *
     * @param username 用户名
     * @return 前十条搜索记录
     */
    @GetMapping("index")
    public Map<String, Object> getIndex(@RequestParam(value = "username", required = false) String username) {
        return myPopupService.getIndex(username);
    }

    /**
     * 输入框实时搜索数据
     *
     * @param keyword 用户输入的关键词
     * @return 符合条件的搜索记录
     */
    @GetMapping("helper")
    public List<String> getHelper(@RequestParam("keyword") String keyword) {
        return goodsService.getGoodsNames(keyword);
    }
}
