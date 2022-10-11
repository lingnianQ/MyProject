package com.syt.springbootee.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/12 1:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult<T> implements Serializable {

    /**
     * 响应状态
     */
    private Integer status;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 成功时响应的数据
     */
    private T data;


    public static <T> JsonResult<T> ok(String message, T data) {
        return new JsonResult<T>(ServiceCode.OK.getValue(), message, data);
    }

    public static <T> JsonResult<T> fail(Integer status, String message) {
        return new JsonResult<T>(status, message, null);
    }
}
