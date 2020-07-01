package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhushangjie
 * @version 1.0
 * @date 2020/6/15 20:39
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLogger(){
        return Logger.Level.FULL;
    }
}
