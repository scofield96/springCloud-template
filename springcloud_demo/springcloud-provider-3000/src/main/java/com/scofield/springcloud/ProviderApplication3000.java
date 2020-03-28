package com.scofield.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Scofield
 * @date 2020/3/26 14:41
 * @description
 */

//@EnableDiscoveryClient不局限于eureka注册中心
//@EnableEurekaClient 以上两注解功能基本相同
@SpringBootApplication
public class ProviderApplication3000 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication3000.class, args);
    }
}
