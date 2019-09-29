package com.guangzhaohui.lrps.common.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 常用的返回工具类
 *
 * @author 李晨辉
 * @date 2019-09-22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultEntity<T> {
    private boolean success;
    private String message;
    private T data;

    public static <T> ResultEntity successResult(T data) {
        return new ResultEntity(true, null, data);
    }

    public static ResultEntity failResult(String message) {
        return new ResultEntity(false, message, null);
    }

    public static <T> ResultEntity failDataResult(T data) {
        return new ResultEntity(false, null, data);
    }
}
