package com.juliuszhu.ecommerce.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * date: 2020/12/24
 * time: 20:37
 *
 * @author:julius.zhu
 * @describe: 用于记录分页信息实体类
 */
@Setter
@Getter
public class PageInfoEntity {
    /**
     * 总记录条数
     */
    private Integer count = 0;
    /**
     * 当前页
     */
    private Integer currentPage = 1;
    /**
     * 总页数
     */
    private Integer totalPages = 1;
    /**
     * 每页显示条数,默认20条
     */
    private Integer pageSize = 20;

    @Override
    public String toString() {
        return "PageEntity{" +
                "count=" + count +
                ", currentPage=" + currentPage +
                ", totalPages=" + totalPages +
                ", pageSize=" + pageSize +
                '}';
    }
}
