package com.rode.cloud;

import com.rode.cloud.annotation.ExcludeFromComponentScan;
import com.rode.cloud.config.UserDefinedConfiguration2;
import com.rode.config.UserDefinedConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Roderick
 * @Description: add the annotation to exclude scan the the class with the ExcludeFromComponentScan annotation.
 * @Date: 21:59 2017/11/27
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="microservice-provider-user",configuration = UserDefinedConfiguration2.class)
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION, value=ExcludeFromComponentScan.class)})
public class ConsumerMovieRibbonApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerMovieRibbonApplication.class, args);
	}
}
