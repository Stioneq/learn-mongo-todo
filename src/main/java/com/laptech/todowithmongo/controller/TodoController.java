package com.laptech.todowithmongo.controller;

import com.laptech.todowithmongo.model.TodoItem;
import com.laptech.todowithmongo.repository.TodoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {

  @Autowired
  private TodoRepository repository;

  @GetMapping
  public List<TodoItem> findAll() {
    return repository.findAll();
  }

  @GetMapping(params = {"skip", "limit"})
  public List<TodoItem> findAllWithPagination(@RequestParam("skip") long skip, @RequestParam("limit") long limit) {
    return repository.findAll(skip, limit);
  }

  @PutMapping
  public void insertOne(@RequestBody TodoItem todoItem) {
    repository.insertOne(todoItem);
  }

  @DeleteMapping("/{id}")
  public boolean removeById(@PathVariable("id") String id) {
    return repository.removeById(id);
  }
  @GetMapping("/{id}")
  public TodoItem findById(@PathVariable("id") String id) {
    return repository.findById(id);
  }

  @GetMapping("/search")
  public List<TodoItem> search(@RequestParam("q") String q) {
    return repository.search(q);
  }
}
