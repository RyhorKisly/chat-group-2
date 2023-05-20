package org.example.chat_group_2.service.api;

import java.util.List;

public interface ICRUDService<T, S> {
    List<T> get();

    T get(int id);

    T save(S item);
}
