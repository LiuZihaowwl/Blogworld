package com.hao.Blogworld.Entity;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code; // 状态码

    private String message; // 状态描述信息

    private T data; // 定义为范型
}
