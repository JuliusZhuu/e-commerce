package com.juliuszhu.ecommerce.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * date: 2020/12/24
 * time: 22:42
 *
 * @author:julius.zhu
 * @describe:热门关键词实体类
 */
@Setter
@Getter
public class HotKeywordList extends BaseEntity {
    /**
     * 名称
     */
    private String keyword;
    /**
     * 是否热门关键词
     */
    private Integer isHot;
    /**
     * 是否默认
     */
    private Integer isDefault;
    /**
     * 是否显示
     */
    private Integer isShow;
}
