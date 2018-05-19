package com.laptech.todowithmongo.repository;

import com.laptech.todowithmongo.model.TodoItem;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TodoRepository extends MongoRepository<TodoItem, String>, SearchRepository<TodoItem> {


}
