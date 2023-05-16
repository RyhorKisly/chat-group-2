package org.example.chat_group_2.service.factory;

import org.example.chat_group_2.dao.memory.factory.UserDaoFactory;
import org.example.chat_group_2.service.UserService;
import org.example.chat_group_2.service.api.IUserService;

public class UserServiceFactory {
    private static volatile IUserService instance;
    private UserServiceFactory() {

    }
    public static IUserService getInstance() {
        if(instance == null) {
            synchronized (UserServiceFactory.class) {
                if(instance == null) {
                    instance = new UserService(UserDaoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
