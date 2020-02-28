package com.example.accessingdatamongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootApplication
public class AccessingDataMongodbApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	@Autowired
	MongoTemplate mongoTemplate;

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataMongodbApplication.class, args);

	}

	public void printCustomer(List < Customer > customers){
		customers.stream().forEach(c -> System.out.println(c.toString()));
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers

		repository.save(new Customer("A", 8, 10000, 20, 10));
		repository.save(new Customer("B", 9, 10001, 25, 11));
		repository.save(new Customer("C", 10, 10002, 30, 12));
		repository.save(new Customer("D", 11, 10003, 40, 13));
		repository.save(new Customer("E", 8, 10004, 35, 10));
		repository.save(new Customer("F", 9, 10000, 30, 11));
		repository.save(new Customer("G", 10, 10001, 25, 12));
		repository.save(new Customer("H", 11, 10001, 20, 13));

		List <Customer> customers;

		customers = mongoTemplate.findAll(Customer.class);
		printCustomer(customers);


		customers = mongoTemplate.find(Query.query(Criteria.where("age").lt(10).and("salary").gt(10000)), Customer.class);


		//List<Customer> customers = mongoTemplate.find(Query.query(Criteria.where("firstName").is("Utsav")), Customer.class);


//		repository.findOne(new Example<Customer>() {
//			@Override
//			public Customer getProbe() {
//				return null;
//			}
//
//			@Override
//			public ExampleMatcher getMatcher() {
//				return null;
//			}
//		})

		// fetch all customers
//		System.out.println("Customers found with findAll():");
//		System.out.println("-------------------------------");
//		for (Customer customer : repository.findAll()) {
//			System.out.println(customer);
//		}
//		System.out.println();
//
//		// fetch an individual customer
//		System.out.println("Customer found with findByFirstName('Alice'):");
//		System.out.println("--------------------------------");

//		Query query = new Query(Criteria.where("LastName").is("Smith"));
//		System.out.println("Customers found with findByLastName('Smith'):");
//		System.out.println("--------------------------------");
////		for (Customer customer : repository(query, Customer.class)) {
////			System.out.println(customer);
////		}
//
//		System.out.println("Customer found with Middle('xyz'):");
//		System.out.println("--------------------------------");
//		for (Customer customer : repository.findByMiddleName("xyz")) {
//			System.out.println(customer);
//		}

	}

}