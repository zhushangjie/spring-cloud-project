package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author zhushangjie
 * @version 1.0
 * @date 2020/6/16 20:18
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "------------PaymentFallbackService fall-back-paymentInfo_OK ┭┮﹏┭┮ ";
    }

    @Override
    public String peymentInfo_TimeOut(Integer id) {
        return "------------PaymentFallbackService fall-back-peymentInfo_TimeOut ┭┮﹏┭┮ ";
    }
}
