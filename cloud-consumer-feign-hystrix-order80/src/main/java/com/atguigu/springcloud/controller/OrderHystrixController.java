package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhushangjie
 * @version 1.0
 * @date 2020/6/15 22:31
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_fallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "peymentInfo_TimeOutHandler", commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="1500")
//    })
    @HystrixCommand
    public String peymentInfo_TimeOut(@PathVariable("id") Integer id){
        int age = 10/0;
        String result =  paymentHystrixService.peymentInfo_TimeOut(id);
        return result;
    }

    public String peymentInfo_TimeOutHandler(@PathVariable("id") Integer id){
        return "我是消费者 80，对方支付系统繁忙，请10秒钟之后再试，或者自己运行出错，请检查自己，┭┮﹏┭┮";
    }

    public String payment_Global_fallbackMethod(){
        return "Global异常处理信息，请稍后再试,(┬＿┬)";
    }
}
