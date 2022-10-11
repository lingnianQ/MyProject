package com.syt.springbootee.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis配置类
 *
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/12 1:32
 */
@MapperScan("com.syt.springbootee.mapper")
@Configuration
public class MybatisConfiguration {
}
