package org.example.chat_group_2.dao.memory;

import org.example.chat_group_2.core.dto.UserDto;
import org.example.chat_group_2.dao.api.IUserDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserDao implements IUserDao {
    private final Map<String, UserDto> users = new ConcurrentHashMap<>();
    @Override
    public List<UserDto> get() {
        return new ArrayList<>(this.users.values());
    }

    @Override
    public UserDto get(String login) {
        return this.users.get(login);
    }

    @Override
    public UserDto save(UserDto item) {
        this.users.put(item.getLogin(), item);
        return item;
    }
}
