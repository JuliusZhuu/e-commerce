package com.juliuszhu.ecommerce.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * date: 2020/12/23
 * time: 22:01
 *
 * @author:julius.zhu
 * @describe: 公共实体类
 */
@Setter
@Getter
public class BaseEntity {
    //每条记录都应该有的id
    private Integer id;
}
