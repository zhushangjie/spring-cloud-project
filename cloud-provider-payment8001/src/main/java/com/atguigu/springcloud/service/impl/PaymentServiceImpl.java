package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhushangjie
 * @version 1.0
 * @date 2020/5/25 21:38
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int  create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id){
        System.out.println(id);
        return paymentDao.getPaymentById(id);
    }
}
