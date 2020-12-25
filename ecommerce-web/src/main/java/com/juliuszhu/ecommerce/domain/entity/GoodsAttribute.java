package com.juliuszhu.ecommerce.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * date: 2020/12/25
 * time: 12:13
 *
 * @author:julius.zhu
 * @describe:商品属性实体
 */
@Setter
@Getter
public class GoodsAttribute extends BaseEntity {
    /**
     * 商品id
     */
    private Integer goodsId;
    /**
     * name
     */
    private String name;
    /**
     * value
     */
    private String value;

    @Override
    public String toString() {
        return "GoodsAttribute{" +
                "goodsId=" + goodsId +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
