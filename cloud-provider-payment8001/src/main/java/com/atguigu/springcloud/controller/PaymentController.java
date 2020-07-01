package com.atguigu.springcloud.controller;

import ch.qos.logback.core.util.TimeUtil;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * @author zhushangjie
 * @version 1.0
 * @date 2020/5/25 21:46
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*********插入结果：" + result);
        if(result > 0){
            return new CommonResult(200,"插入数据库成功,serverPort:" + serverPort,result);
        }else{
            return new CommonResult(404, "插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment != null){
            log.info("*********查询结果dsadasdsads：" + payment);
            return new CommonResult(200, "查询数据成功,serverPort:" + serverPort,payment);
        }else{
            return new CommonResult(404, "查询数据没有对应记录，查询id=" + id,null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
       List<String> list =  discoveryClient.getServices();
       for (String element : list){
           log.info("****element: " + element);
       }
       List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances){
            log.info("****serviceId:" + instance.getInstanceId() + "***hostName:" + instance.getHost() +
                    "***port:" + instance.getPort() + "***url:" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;
    }

}
