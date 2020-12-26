package com.altimetrik.citybank.mongo.app.mongoappwithcriteria.controller;

import com.altimetrik.citybank.mongo.app.mongoappwithcriteria.model.Employee;
import com.altimetrik.citybank.mongo.app.mongoappwithcriteria.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping("/getAllEmployee")
    public List<Employee> getAllEmployee()
    {
       return service.getAllEmployee();
    }

    @PostMapping ("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        return service.addEmployee(employee);
    }
    @PutMapping  ("/saveOrUpdateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee)
    {
        return service.updateEmployee(employee);
    }

    @DeleteMapping  ("/removeEmployee/{id}")
    public void deleteEmployee(@PathVariable String id)
    {
        service.deleteEmployee(id);
    }

    @GetMapping("/pagination")
    public Map<String ,Object> getAllEmployeeInPage(
            @RequestParam (name = "pagNo",defaultValue = "0") int pageNO,
            @RequestParam (name = "pagSize",defaultValue = "2") int pageSize,
             @RequestParam (name = "sortBy",defaultValue = "id") String sortBy )
    {
        return service.getAllEmployeeInPage(pageNO,pageSize,sortBy);
    }


    @GetMapping("/example")
    public List<Employee> getAllEmployeeWithExample(@RequestBody Employee employee)
    {
        return service.getAllEmployeeWithExample(employee);
    }

    @GetMapping("/findbyFirstName/{firstName}")
    public List<Employee> getAllEmployeeWithFirstName(@PathVariable String  firstName)
    {
        return service.getAllEmployeeWithFirstName(firstName);
    }
    @GetMapping("/findbyZipCode/{zipCode}")
    public List<Employee> getAllEmployeeWithZipCode(@PathVariable int  zipCode)
    {
        return service.getAllEmployeeWithZipCode(zipCode);
    }
    @GetMapping("/findbyCity/{city}")
    public List<Employee> getAllEmployeeWithCity(@PathVariable String  city)
    {
        return service.getAllEmployeeWithCity(city);
    }

    @GetMapping("/findbyGreaterThenSalary/{salary}")
    public List<Employee> findbyGreaterThenSalary(@PathVariable float  salary)
    {
        return service.findbyGreaterThenSalary(salary);
    }
    @GetMapping("/findbyMinMax/{min},{max}")
    public List<Employee> findbyMinMax(@PathVariable float  min,@PathVariable float  max)
    {
        return service.findbyMinMax(min,max);
    }





}
