package org.example.chat_group_2.service.api;

import org.example.chat_group_2.core.dto.MessageDto;

import java.util.List;

public interface IMessageService<T, S> {
    List<MessageDto> getMessagesForUser(int userId);

    void setService(IUserService userService);
    List<T> get();

    T get(int id);

    T save (S item);
}
