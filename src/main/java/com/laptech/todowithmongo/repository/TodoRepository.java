package com.laptech.todowithmongo.repository;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.limit;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.skip;

import com.laptech.todowithmongo.model.TodoItem;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepository {

  @Autowired
  private MongoTemplate mongoTemplate;

  public List<TodoItem> findAll() {
    return mongoTemplate.findAll(TodoItem.class);
  }

  public void insertOne(TodoItem item) {
    item.setCreated(LocalDateTime.now());
    mongoTemplate.insert(item);
  }

  public List<TodoItem> findAll(long skip, long limit) {
    Aggregation aggregation = newAggregation(
        skip(skip),
        limit(limit)
    );
    AggregationResults<TodoItem> results = mongoTemplate
        .aggregate(aggregation, "items", TodoItem.class);

    return results.getMappedResults();
  }

  public void removeAll() {
    mongoTemplate.remove(TodoItem.class);
  }

  public boolean removeById(String id) {
    return mongoTemplate.remove(Query.query(Criteria.where("_id").is(id))).getDeletedCount() == 1;
  }

  public TodoItem findById(String id) {
    return mongoTemplate.findById(id, TodoItem.class);
  }
}
