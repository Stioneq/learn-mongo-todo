package com.laptech.todowithmongo.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

  @Override
  public MongoClient mongoClient() {
    return new MongoClient(new MongoClientURI("mongodb+srv://m001-student:qsefthuko@cluster0-fdsjy.mongodb.net/test?retryWrites=true"));
  }

  @Override
  protected String getDatabaseName() {
    return "todo";
  }
}
