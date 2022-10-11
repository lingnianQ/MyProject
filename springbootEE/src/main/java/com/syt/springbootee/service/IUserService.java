package com.syt.springbootee.service;

import com.syt.springbootee.pojo.dto.UserAddNewDTO;
import com.syt.springbootee.pojo.entity.User;

/**
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/12 1:41
 */
public interface IUserService {

    /**
     * 添加新用户
     *
     * @param userAddNewDTO
     */
    void addNew(UserAddNewDTO userAddNewDTO);

}
