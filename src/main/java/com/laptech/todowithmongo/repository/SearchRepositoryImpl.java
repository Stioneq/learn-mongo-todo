package com.laptech.todowithmongo.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Component;

@Component
public class SearchRepositoryImpl<T>  implements SearchRepository<T>{

  @Autowired
  private MongoTemplate mongoTemplate;

  @Override
  public List<T> search(String searchQuery, Class<T> tClass) {
    TextCriteria textCriteria = TextCriteria.forDefaultLanguage().matchingAny(searchQuery);
    Query query = TextQuery.query(textCriteria);
    return mongoTemplate.find(query, tClass);
  }
}
