package com.scofield.springcloud.web;

import com.scofield.springcloud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Scofield
 * @date 2020/3/26 15:08
 * @description
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;





    @RequestMapping("/consumer/ribbon/get/employee")
    public Employee getEmployeeRemote() {
         // 远程调用方法的主机地址
        String host = "http://springcloud-provider";
        // 远程调用方法的具体URL 地址
        String url = "/provider/get/employee/remote";
        return restTemplate.getForObject(host + url, Employee.class);
    }

}
