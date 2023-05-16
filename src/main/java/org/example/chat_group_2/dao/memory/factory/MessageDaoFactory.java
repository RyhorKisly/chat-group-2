package org.example.chat_group_2.dao.memory.factory;

import org.example.chat_group_2.dao.api.IMessageDao;
import org.example.chat_group_2.dao.memory.MessageMemoryDao;

public class MessageDaoFactory {
    private static volatile IMessageDao instance;

    private MessageDaoFactory() {

    }
    public static IMessageDao getInstance() {
        if(instance == null) {
            synchronized (MessageDaoFactory.class) {
                if(instance == null) {
                    instance = new MessageMemoryDao();
                }
            }
        }
        return instance;
    }
}
