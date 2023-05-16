package org.example.chat_group_2.dao.memory.factory;

import org.example.chat_group_2.dao.api.IUserDao;
import org.example.chat_group_2.dao.memory.UserMemoryDao;

public class UserDaoFactory {
    private static volatile IUserDao instance;

    private UserDaoFactory() {

    }
    public static IUserDao getInstance() {
        if(instance == null) {
            synchronized (UserDaoFactory.class) {
                if(instance == null) {
                    instance = new UserMemoryDao();
                }
            }
        }
        return instance;
    }
}
