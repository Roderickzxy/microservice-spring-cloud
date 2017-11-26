package com.rode.cloud.controller;


import com.rode.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/movie/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        //虚拟ip(virtual IP)
        return restTemplate.getForObject("http://microservice-provider-user/user/" + id, User.class);
    }

    @GetMapping("/testDefinedRibbon")
    public String ribbon(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");
        System.out.println("host: "+serviceInstance.getHost()+" port: "+serviceInstance.getPort()+" serviceId: "+serviceInstance.getServiceId());
        ServiceInstance serviceInstance2 = loadBalancerClient.choose("microservice-provider-user2");
        System.out.println("host: "+serviceInstance2.getHost()+" port: "+serviceInstance2.getPort()+" serviceId: "+serviceInstance2.getServiceId());
        return "success";
    }
}
