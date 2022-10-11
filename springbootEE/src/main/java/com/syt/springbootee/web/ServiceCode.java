package com.syt.springbootee.web;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/12 1:35
 */
@AllArgsConstructor
public enum ServiceCode {
    /**
     * 成功状态
     */
    OK(20000),
    ERR_BAD_REQUEST(40000),
    ERR_UNAUTHORIZED(40100),
    ERR_UNAUTHORIZED_DISABLED(40110),
    ERR_FORBIDDEN(40300),
    ERR_NOT_FOUND(40400),
    ERR_CONFLICT(40900),
    ERR_INSERT(50000),
    ERR_DELETE(50100),
    ERR_UPDATE(50200),
    ERR_JWT_EXPIRED(60000),
    ERR_JWT_PARSE(60100);

    @Getter
    private final int value;

    @Override
    public String toString() {
        return "" + value;
    }
}
