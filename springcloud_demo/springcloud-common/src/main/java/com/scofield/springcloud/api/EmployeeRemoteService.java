package com.scofield.springcloud.api;

import com.scofield.springcloud.entity.Employee;
import com.scofield.springcloud.factory.MyFallBackFactory;
import com.scofield.springcloud.util.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Scofield
 * @date 2020/3/26 17:58
 * @description
 */
// @FeignClient表示当前接口和一个provider对应,value指定要调用的provider的微服务名称
//fallbackFactory指定provider
@FeignClient(value = "springcloud-provider", fallbackFactory = MyFallBackFactory.class)
public interface EmployeeRemoteService {

    // 远程调用的接口方法
    // 要求@RequestMapping注解映射的地址一致
    // 要求方法声明一致
    // 用来获取请求参数的@RequestParam、@PathVariable、@RequestBody不能省略，两边一致
    @RequestMapping("/provider/get/employee/remote")
    public Employee getEmployeeRemote();

    @RequestMapping("/provider/get/emp/list/remote")
    public List<Employee> getEmpListRemote(String keyword);

    @RequestMapping("/provider/get/emp/with/circuit/breaker")
    public ResultEntity<Employee> getEmpWithCircuitBreaker(@RequestParam("signal") String signal);

}
