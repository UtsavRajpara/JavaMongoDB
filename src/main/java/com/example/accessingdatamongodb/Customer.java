package com.example.accessingdatamongodb;

import org.springframework.data.annotation.Id;


public class Customer {

    @Id
    public String id;

    public String name;
    public Integer age;
    public Integer salary;
    public FacebookPost post;

    public Customer() {}

    public Customer(String name, Integer age, Integer salary, Integer likes, Integer comments) {
        this.post = new FacebookPost(likes, comments);
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, name='%s', Age='%d', Salary=%d, Likes=%d, Comments=%d]",
                id, name, age, salary, post.likes, post.comments);
    }

}