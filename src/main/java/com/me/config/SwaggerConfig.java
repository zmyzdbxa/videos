package com.me.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createDocket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .groupName("java2007")
                .enable(true)
                .select().apis(RequestHandlerSelectors.basePackage("com.me.controller"))
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("老表的小测试")
                .description("api接口文档描述")
                .termsOfServiceUrl("http://10.8.157.28:8080/swagger-ui.html")
                .version("1.o")
                .contact(new Contact("jack", "jack_url", "jack_email"))
                .license("java2007")
                .licenseUrl("java2007.url")
                .build();
    }
}
