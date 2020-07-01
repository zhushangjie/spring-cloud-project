package com.atguigu.springcloud;

import com.atguigu.mylbrule.MYselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author zhushangjie
 * @version 1.0
 * @date 2020/5/26 21:58
 */
@SpringBootApplication
@EnableEurekaClient
//表示对“CLOUD-PAYMENT-SERVICE”， 将默认为轮询的LB,改为我自己在类中配置的LB规则
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MYselfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
