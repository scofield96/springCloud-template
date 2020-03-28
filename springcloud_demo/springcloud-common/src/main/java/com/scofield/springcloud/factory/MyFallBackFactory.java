package com.scofield.springcloud.factory;

import com.scofield.springcloud.api.EmployeeRemoteService;
import com.scofield.springcloud.entity.Employee;
import com.scofield.springcloud.util.ResultEntity;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 1.实现consumer服务降级功能
 * 2.实现FallbackFactory接口传入@FeignClient标记的接口类型
 * 3.在create（）方法中返回@FeignClient注解标记的接口类型的对象，当Provider调用失败后，后执行这个对象对应的方法
 * 4.@Component加入Ioc容器
 * @author Scofield
 * @date 2020/3/27 21:33
 * @description
 */
@Component
public class MyFallBackFactory implements FallbackFactory<EmployeeRemoteService> {

    @Override
    public EmployeeRemoteService create(Throwable cause) {
        return new EmployeeRemoteService() {
            @Override
            public Employee getEmployeeRemote() {
                return null;
            }

            @Override
            public ResultEntity<Employee> getEmpWithCircuitBreaker(String signal) {
                return ResultEntity.failed("降级机制生效：" + cause.getMessage());
            }

            @Override
            public List<Employee> getEmpListRemote(String keyword) {
                return null;
            }
        };
    }
}
