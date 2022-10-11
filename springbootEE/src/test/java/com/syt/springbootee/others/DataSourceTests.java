package com.syt.springbootee.others;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/12 1:16
 */
@Slf4j
@SpringBootTest
public class DataSourceTests {

    @Autowired
    private DataSource dataSource;

    @Test
    void testConn(){
        try {
            dataSource.getConnection();
            log.debug("数据库连接成功");
        } catch (SQLException e) {
            log.warn("数据库连接失败");
        }
    }
}
