package com.scofield.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author Scofield
 * @date 2020/3/27 22:08
 * @description
 */
// 启用Hystrix 仪表盘功能
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashBoardApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBoardApplication.class, args);
    }
}
