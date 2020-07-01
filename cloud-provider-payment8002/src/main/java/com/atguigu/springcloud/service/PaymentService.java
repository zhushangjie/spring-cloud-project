package com.atguigu.springcloud.service;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhushangjie
 * @version 1.0
 * @date 2020/5/25 21:38
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
