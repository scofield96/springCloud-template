package com.scofield.springcloud.web;

import com.scofield.springcloud.entity.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Scofield
 * @date 2020/3/26 14:43
 * @description
 */
@RestController
public class EmployeeController {

    @RequestMapping("/provider/get/employee/remote")
    public Employee getEmployeeRemote(HttpServletRequest request) {
        int serverPort = request.getServerPort();

        return new Employee(123456, "scofield"+serverPort, 1111.11);
    }

}
