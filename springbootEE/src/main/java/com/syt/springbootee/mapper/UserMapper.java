package com.syt.springbootee.mapper;

import com.syt.springbootee.pojo.entity.User;

/**
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/12 1:32
 */
public interface UserMapper {
    /**
     * 插入用户
     * @param user
     * @return
     */
    int insert(User user);
}
