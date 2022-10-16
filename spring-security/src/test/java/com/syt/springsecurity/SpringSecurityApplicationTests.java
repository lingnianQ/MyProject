package com.syt.springsecurity;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@Slf4j
@SpringBootTest
class SpringSecurityApplicationTests {


    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        dataSource.getConnection();

        log.info("数据库连接成功");
    }

}
