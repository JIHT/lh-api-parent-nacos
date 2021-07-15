package com.lihua.feedcontrollerapi;

import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@EnableNacosConfig
@EnableDiscoveryClient

@EnableAspectJAutoProxy
@MapperScan(basePackages = {"com.lihua.feedcontrollerapi.dao"})
@EnableCaching
//关闭自动登陆
@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class FeedControllerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeedControllerApiApplication.class, args);
    }

}
