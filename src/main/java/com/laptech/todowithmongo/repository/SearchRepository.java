package com.laptech.todowithmongo.repository;

import java.util.List;

public interface SearchRepository<T> {

  List<T> search(String query, Class<T> tClass);
}
