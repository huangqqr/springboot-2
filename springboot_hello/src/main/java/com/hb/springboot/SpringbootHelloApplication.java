package com.hb.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * 加载外部的xml的配置
 */
@ImportResource(locations = {"classpath:beans.xml"})
@SpringBootApplication
@ServletComponentScan
public class SpringbootHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHelloApplication.class, args);
    }

}
