package com.altimetrik.citybank.mongo.app.mongoappwithcriteria.service;

import com.altimetrik.citybank.mongo.app.mongoappwithcriteria.model.Employee;
import com.altimetrik.citybank.mongo.app.mongoappwithcriteria.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;
    public List<Employee> getAllEmployee() {
        return repository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return repository.insert(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return repository.save(employee);
    }
    public void deleteEmployee(String id)
    {
        repository.deleteById(id);
    }

    public Map<String, Object> getAllEmployeeInPage(int pageNO, int pageSize, String sortBy) {

        Map<String, Object> employees=new HashMap<>();
        Sort sort= Sort.by(sortBy);
        Pageable page= PageRequest.of(pageNO,pageSize,sort);
        Page <Employee> employeePage=repository.findAll(page);
        employees.put("Data Content is :",employeePage.getContent());
        employees.put("Total no of Page is :",employeePage.getTotalPages());
        employees.put("Total no of Elements is :",employeePage.getTotalElements());
        employees.put("Current oage no  is :",employeePage.getNumber());
        return employees;
    }

    public List<Employee> getAllEmployeeWithExample(Employee employee) {

        ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAny()
                .withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("lastName", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        Example<Employee> example = Example.of(employee, customExampleMatcher);

        return repository.findAll(example);
    }

    public List<Employee> getAllEmployeeWithFirstName(String firstName) {
        return repository.findByFirstNameIgnoreCase(firstName);
    }

    public List<Employee> getAllEmployeeWithZipCode(int zipCode) {
        return repository.findByAddressZipCode(zipCode);
    }

    public List<Employee> getAllEmployeeWithCity(String city) {
        return repository.findByAddressCityIgnoreCase(city);
    }

    public List<Employee> findbyGreaterThenSalary(float salary) {
        return repository.findbyGreaterThenSalary(salary);
    }

    public List<Employee> findbyMinMax(float min, float max) {
        return repository.findbyMinMax(min,max);
    }
}
