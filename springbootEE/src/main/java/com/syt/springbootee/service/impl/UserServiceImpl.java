package com.syt.springbootee.service.impl;

import com.syt.springbootee.mapper.UserMapper;
import com.syt.springbootee.pojo.dto.UserAddNewDTO;
import com.syt.springbootee.pojo.entity.User;
import com.syt.springbootee.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/12 1:40
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public void addNew(UserAddNewDTO userAddNewDTO) {

        User user = new User();
        BeanUtils.copyProperties(userAddNewDTO, user);

        log.debug("开始插入用户");
        int rows = userMapper.insert(user);
        log.debug("rows: {}", rows);
    }
}
