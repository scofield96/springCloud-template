package com.scofield.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Scofield
 * @date 2020/3/26 14:41
 * @description
 */
@EnableCircuitBreaker//开启断路器功能
//@EnableDiscoveryClient不局限于eureka注册中心
//@EnableEurekaClient 以上两注解功能基本相同
@SpringBootApplication
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
