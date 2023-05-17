package org.example.chat_group_2.service.factory;

import org.example.chat_group_2.dao.memory.factory.MessageDaoFactory;
import org.example.chat_group_2.service.MessageService;
import org.example.chat_group_2.service.api.IMessageService;

public class MessageServiceFactory {
    private static volatile IMessageService instance;

    private MessageServiceFactory() {
    }

    public static IMessageService getInstance() {
        if (instance == null) {
            synchronized (MessageServiceFactory.class) {
                if (instance == null) {
                   // instance = new MessageService(MessageDaoFactory.getInstance());
                }
            }
        }

        return instance;
    }
}
