package com.juliuszhu.ecommerce.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * date: 2021/1/2
 * time: 23:25
 *
 * @author:julius.zhu
 * @describe:统一的响应实体,用户返回json数据
 */
@Setter
@Getter
public class ResponseEntity {
    private int status;

    private String msg;

    private Object data;

    @Override
    public String toString() {
        return "ResponseEntity{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
