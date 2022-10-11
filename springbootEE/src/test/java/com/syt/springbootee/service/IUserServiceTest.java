package com.syt.springbootee.service;

import com.syt.springbootee.pojo.dto.UserAddNewDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/12 1:59
 */
@Slf4j
@SpringBootTest
class IUserServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    void addNew() {
        UserAddNewDTO userAddNewDTO = UserAddNewDTO.builder()
                .username("Q")
                .password("12343")
                .build();
        userService.addNew(userAddNewDTO);
    }
}