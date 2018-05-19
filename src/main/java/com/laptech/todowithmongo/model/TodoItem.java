package com.laptech.todowithmongo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items")
@Data
public class TodoItem {

  @JsonProperty("id")
  private String _id;
  @TextIndexed(weight = 2)
  private String title;
  private LocalDateTime created;
  @TextIndexed
  private String content;
}
