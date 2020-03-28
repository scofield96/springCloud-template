package com.scofield.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Scofield
 * @date 2020/3/26 18:33
 * @description
 */
//启用Feign客户端功能
@EnableFeignClients
@SpringBootApplication
public class ConsumerFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignApplication.class,args);
    }
}
