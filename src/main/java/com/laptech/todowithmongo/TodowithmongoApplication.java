package com.laptech.todowithmongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

@SpringBootApplication
public class TodowithmongoApplication implements CommandLineRunner {

  @Autowired
  MongoTemplate mongoTemplate;

  public static void main(String[] args) {
    SpringApplication.run(TodowithmongoApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println(mongoTemplate.getDb().getName());
  }
}
