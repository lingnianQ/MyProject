package com.syt.springbootee.mapper;

import com.syt.springbootee.pojo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/12 1:49
 */
@Slf4j
@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testInsert() {
        User user = User.builder()
                .username("test")
                .password("123456")
                .loginCount(0)
                .build();
        int rows = userMapper.insert(user);
        System.out.println("rows = " + rows);
    }
}