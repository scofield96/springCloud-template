package com.scofield.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Scofield
 * @date 2020/3/26 15:07
 * @description
 */
@Configuration
public class SpringcloudConfig {

    @Bean
    @LoadBalanced//让RestTemplate有负载均衡功能，通过调用ribbon访问provider集群
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
