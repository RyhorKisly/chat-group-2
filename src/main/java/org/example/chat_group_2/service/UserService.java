package org.example.chat_group_2.service;

import org.example.chat_group_2.core.dto.UserDto;
import org.example.chat_group_2.dao.api.IUserDao;
import org.example.chat_group_2.service.api.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private final IUserDao userDao;

    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<UserDto> get() {
        return userDao.get();
    }

    @Override
    public UserDto get(String login) {
        return userDao.get(login);
    }

    @Override
    public UserDto save(UserDto item) {
        return userDao.save(item);
    }
}
