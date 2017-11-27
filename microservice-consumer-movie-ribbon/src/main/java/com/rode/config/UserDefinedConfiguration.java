package com.rode.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Roderick
 * @Description: defined beyond the application class's package
 * which will not be scanned by spring boot and it can be configurated for specified service
 * @Date: 21:45 2017/11/27
 */
@Configuration
public class UserDefinedConfiguration {


    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
