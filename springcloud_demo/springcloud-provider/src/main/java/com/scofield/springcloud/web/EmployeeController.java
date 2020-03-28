package com.scofield.springcloud.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.scofield.springcloud.entity.Employee;
import com.scofield.springcloud.util.ResultEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Scofield
 * @date 2020/3/26 14:43
 * @description
 */
@RestController
public class EmployeeController {

    private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    // @HystrixCommand 注解通过fallbackMethod 属性指定断路情况下要调用的备份方法
    @HystrixCommand(fallbackMethod = "getEmpBackup")
    @RequestMapping("/provider/circuit/breaker/get/emp")
    public ResultEntity<Employee> getEmp(@RequestParam("signal") String signal) throws InterruptedException {
        if("quick-beng".equals(signal)) {
            throw new RuntimeException();
        }
        if ("slow-beng".equals(signal)){
            Thread.sleep(5000);
        }
        return ResultEntity.successWithData(new Employee(666, "sam666", 666.66));
    }

    public ResultEntity<Employee> getEmpBackup(@RequestParam("signal") String signal) {
        String message = "方法出现问题，执行此断路 signal="+signal;
        return ResultEntity.failed(message);
    }

    @RequestMapping("/provider/get/emp/list/remote")
    public List<Employee> getEmpListRemote(@RequestParam("keyword") String keyword) {

        logger.info("keyword="+keyword);

        List<Employee> empList = new ArrayList<>();

        empList.add(new Employee(1111, "zhang1111", 111.00));
        empList.add(new Employee(2222, "zhang2222", 222.00));
        empList.add(new Employee(3333, "zhang3333", 333.00));

        return empList;
    }


    @RequestMapping("/provider/get/employee/remote")
    public Employee getEmployeeRemote() {


        return new Employee(123456, "scofield", 1111.11);
    }




  /*  @RequestMapping("/provider/get/employee/remote")
    public Employee getEmployeeRemote(HttpServletRequest request) {
        int serverPort = request.getServerPort();

        return new Employee(123456, "scofield"+serverPort, 1111.11);
    }*/

}
