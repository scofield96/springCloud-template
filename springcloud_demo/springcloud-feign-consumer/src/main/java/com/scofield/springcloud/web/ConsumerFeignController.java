package com.scofield.springcloud.web;

import com.scofield.springcloud.api.EmployeeRemoteService;
import com.scofield.springcloud.entity.Employee;
import com.scofield.springcloud.util.ResultEntity;
import com.sun.org.apache.xpath.internal.compiler.Keywords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Scofield
 * @date 2020/3/26 18:37
 * @description
 */
@RestController
public class ConsumerFeignController {

    @Autowired
    private EmployeeRemoteService employeeRemoteService;


    @RequestMapping("/feign/consumer/test/fallback")
    public ResultEntity<Employee> testFallBack(@RequestParam("signal") String signal){
        return employeeRemoteService.getEmpWithCircuitBreaker(signal);
    }

    @RequestMapping("/feign/consumer/get/emp")
    public Employee getEmployeeRemote() {
        return employeeRemoteService.getEmployeeRemote();
    }

    @RequestMapping("/feign/consumer/search")
    public List<Employee> getEmpListRemote(String keyword){
        return employeeRemoteService.getEmpListRemote(keyword);
    }




}
