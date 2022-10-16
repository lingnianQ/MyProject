package com.syt.springsecurity.config;

import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * Knife4j配置类
 *
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/17 3:41
 */
@Slf4j
@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfiguration {



    /**
     * 打开API拓展器
     */
    @Autowired
    private OpenApiExtensionResolver openApiExtensionResolver;

    public Knife4jConfiguration() {
        log.debug("-----创建API配置类: Knife4jConfiguration");
    }


    @Bean
    public Docket docket() {
        String groupName = "1.0.0";
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .host("http://127.0.0.1")
                .apiInfo(apiInfo())
                .groupName(groupName)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.syt.springsecurity.controller"))
                .paths(PathSelectors.any())
                .build()
                .extensions(openApiExtensionResolver.buildExtensions(groupName));
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API文档")
                .description("spring-security-线API文档")
                .termsOfServiceUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .contact(new Contact("mySecurityDemo", "http://127.0.0.1", "sytsnb@gamil.com"))
                .version("1.0.0")
                .build();
    }

}
