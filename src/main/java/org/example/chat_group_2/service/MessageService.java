package org.example.chat_group_2.service;

import org.example.chat_group_2.core.dto.MessageDto;
import org.example.chat_group_2.dao.api.IMessageDao;
import org.example.chat_group_2.service.api.IMessageService;
import org.example.chat_group_2.service.api.IUserService;

import java.util.List;

public class MessageService implements IMessageService {
    private IMessageDao messageDao;
    private IUserService userService;

    @Override
    public List<MessageDto> getMessagesForUser(int userId) {
        return null;
    }

    @Override
    public void setService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public List<MessageDto> get() {
        return messageDao.get();
    }

    @Override
    public Object get(int id) {
        return null;
    }

    @Override
    public Object save(Object item) {
        return null;
    }
}
