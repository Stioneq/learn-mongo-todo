package com.laptech.todowithmongo.controller;

import com.laptech.todowithmongo.model.TodoItem;
import com.laptech.todowithmongo.repository.TodoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
  public List<TodoItem> findAllWithPagination(@RequestParam("skip") int skip,
      @RequestParam("limit") int limit) {
    return repository.findAll(PageRequest.of(skip * limit, limit)).getContent();
  }

  @PutMapping
  public TodoItem insertOne(@RequestBody TodoItem todoItem) {
    return repository.insert(todoItem);
  }

  @DeleteMapping("/{id}")
  public boolean removeById(@PathVariable("id") String id) {
    try {
      repository.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @GetMapping("/{id}")
  public TodoItem findById(@PathVariable("id") String id) {
    return repository.findById(id).orElseThrow(() -> new RuntimeException("Element not found"));
  }

  @GetMapping("/search")
  public List<TodoItem> search(@RequestParam(value = "q", defaultValue = "") String q) {
    if (q.isEmpty()) {
      return repository.findAll();
    }
    return repository.search(q, TodoItem.class);
  }
}
