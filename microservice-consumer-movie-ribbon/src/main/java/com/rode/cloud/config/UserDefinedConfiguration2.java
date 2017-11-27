package com.rode.cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.rode.cloud.annotation.ExcludeFromComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Roderick
 * @Description: defined under the same package with Application class.
 * Which will be scanned by Spring Boot, unless config the annotation to exclude this config.
 * @Date: 21:46 2017/11/27
 */
@Configuration
@ExcludeFromComponentScan
public class UserDefinedConfiguration2 {

    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
