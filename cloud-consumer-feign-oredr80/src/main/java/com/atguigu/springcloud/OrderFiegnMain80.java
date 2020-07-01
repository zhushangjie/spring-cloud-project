package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhushangjie
 * @version 1.0
 * @date 2020/6/6 13:41
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFiegnMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFiegnMain80.class, args);
    }
}
