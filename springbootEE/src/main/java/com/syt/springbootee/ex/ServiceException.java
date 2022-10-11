package com.syt.springbootee.ex;

import com.syt.springbootee.web.ServiceCode;
import lombok.Getter;

/**
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/12 1:35
 */
public class ServiceException extends RuntimeException {

    @Getter
    private final ServiceCode serviceCode;

    public ServiceException(ServiceCode serviceCode, String message) {
        super(message);
        this.serviceCode = serviceCode;
    }

}
