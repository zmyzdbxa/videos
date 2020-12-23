package com.me;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.me.dao")
public class VideosApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideosApplication.class, args);
    }

}
