package com.juliuszhu.ecommerce.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * date: 2020/12/25
 * time: 12:17
 *
 * @author:julius.zhu
 * @describe:商品常见问题
 */
@Setter
@Getter
public class GoodsIssue extends BaseEntity {
    /**
     * 商品id
     */
    private Integer goodsId;
    /**
     * 问题
     */
    private String question;
    /**
     * 回答
     */
    private String answer;

    @Override
    public String toString() {
        return "GoodsIssue{" +
                "goodsId=" + goodsId +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
