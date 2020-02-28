package com.example.accessingdatamongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public List <Customer> findByName(String firstName);
    public List<Customer> findByAge(Integer age);
    public List<Customer> findBySalary(Integer salary);

}

