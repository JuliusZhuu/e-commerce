package com.juliuszhu.ecommerce.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * date: 2020/12/24
 * time: 22:24
 *
 * @author:julius.zhu
 * @describe:用户搜索关键词实体类
 */
@Setter
@Getter
public class HistoryKeywordList extends BaseEntity {
    /**
     * 关键词名称
     */
    private String name;
    /**
     * 搜索的用户名
     */
    private String username;
}
