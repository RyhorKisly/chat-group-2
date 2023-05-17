package org.example.chat_group_2.dao.api;

import java.util.List;

public interface ICRUDDao<T> {
    List<T> get();

    T get(int id);

    T save(T item);
}
