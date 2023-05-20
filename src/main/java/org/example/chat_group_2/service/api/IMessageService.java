package org.example.chat_group_2.service.api;

import org.example.chat_group_2.core.dto.MessageCreateDto;
import org.example.chat_group_2.core.dto.MessageDto;

import java.util.List;

public interface IMessageService  extends ICRUDService<MessageDto, MessageCreateDto> {
    List<MessageDto> getMessagesForUser(String userLogin);

    List<MessageDto> getMessagesUser(String userLogin);

    void setService(IUserService userService);

    List<MessageDto> getMessagesForUsers(String currentUserLogin, String recipientUserLogin);

    void delete(int id);
}
