package com.rode.cloud.controller;


import com.rode.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/movie/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        //虚拟ip(virtual IP)
        return restTemplate.getForObject("http://microservice-provider-user/user/" + id, User.class);
    }
}
