package com.altimetrik.citybank.mongo.app.mongoappwithcriteria.repository;

import com.altimetrik.citybank.mongo.app.mongoappwithcriteria.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee ,String> {

    List<Employee> findByFirstNameIgnoreCase(String firstName);

    List<Employee> findByAddressCityIgnoreCase(String city);

    List<Employee> findByAddressZipCode(int zipCode);

    @Query(value = "{'salary':{$gte:?0} }",fields = "{'id':0}") //id is zero means it should not display
    List<Employee> findbyGreaterThenSalary(float salary);

    @Query(value = "{'salary':{$gte:?0},{$lte:?1} }")  //0 means first parameter,1 means second
    List<Employee> findbyMinMax(float min, float max);
}
