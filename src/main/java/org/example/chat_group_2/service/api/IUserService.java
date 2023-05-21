package org.example.chat_group_2.service.api;

import org.example.chat_group_2.core.dto.UserDto;

import java.util.List;

public interface IUserService {
    List<UserDto> get();
    UserDto get(String login);
    UserDto save(UserDto genre);
    UserDto findByLogin(String login);
}
