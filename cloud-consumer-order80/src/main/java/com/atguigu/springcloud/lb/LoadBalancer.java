package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author zhushangjie
 * @version 1.0
 * @date 2020/6/2 22:48
 */
public interface LoadBalancer {

    /**
     * 收集注册到注册中心（eureka）上的所有的服务
     */
    ServiceInstance instance(List<ServiceInstance> serviceInstances);

}
