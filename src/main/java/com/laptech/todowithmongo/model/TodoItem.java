package com.laptech.todowithmongo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items")
@Data
public class TodoItem {
  private String _id;
  @Indexed(unique = true)
  @TextIndexed(weight = 2)
  private String title;
  private LocalDateTime created;
  @TextIndexed
  private String content;
}
