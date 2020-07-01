package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhushangjie
 * @version 1.0
 * @date 2020/6/29 22:30
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        return iMessageProvider.send();
    }
}
