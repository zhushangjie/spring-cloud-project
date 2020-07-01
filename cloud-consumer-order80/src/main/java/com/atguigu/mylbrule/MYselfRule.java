package com.atguigu.mylbrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhushangjie
 * @version 1.0
 * @date 2020/6/2 21:43
 */
@Configuration
public class MYselfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();//定义为随机
    }
}
