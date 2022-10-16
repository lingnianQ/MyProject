package com.syt.springsecurity.config;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis的配置类
 *
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/17 3:51
 */
@Slf4j
@Configuration
@MapperScan("com.syt.springsecurity.mapper")
public class MybatisConfiguration {
    public MybatisConfiguration() {
        log.debug("-----创建mybatis配置类: MybatisConfiguration");
    }
}
