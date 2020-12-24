package com.juliuszhu.ecommerce.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * date: 2020/12/24
 * time: 22:09
 *
 * @author:julius.zhu
 * @describe:商品查询条件实体类
 */
@Setter
@Getter
public class GoodsSelectCondition {
    /**
     * 搜索关键词
     */
    private String keyword;
    /**
     * 当前页
     */
    private Integer page = 1;
    /**
     * 每页显示条数
     */
    private Integer size = 10;
    /**
     * 价格排序方式,默认降序
     */
    private String order = "desc";
    /**
     * 商品分类
     */
    private Integer categoryId;

    @Override
    public String toString() {
        return "GoodsSelectCondition{" +
                "keyword='" + keyword + '\'' +
                ", page=" + page +
                ", size=" + size +
                ", order='" + order + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}
