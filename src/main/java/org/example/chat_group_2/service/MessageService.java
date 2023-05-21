package org.example.chat_group_2.service;

import org.example.chat_group_2.core.dto.MessageCreateDto;
import org.example.chat_group_2.core.dto.MessageDto;
import org.example.chat_group_2.core.dto.UserDto;
import org.example.chat_group_2.dao.api.IMessageDao;
import org.example.chat_group_2.service.api.IMessageService;
import org.example.chat_group_2.service.api.IUserService;

import java.time.LocalDateTime;
import java.util.*;

public class MessageService implements IMessageService {
    private final IMessageDao messageDao;
    private IUserService userService;

    public MessageService(IMessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public List<MessageDto> get() {
        return messageDao.get();
    }

    @Override
    public MessageDto get(int id) {
        return messageDao.get(id);
    }

    @Override
    public MessageDto save(MessageCreateDto item) {
        OptionalInt maxId = this.get()
                .stream()
                .mapToInt(MessageDto::getId)
                .max();
        int maxCurrentId = maxId.isPresent() ? maxId.getAsInt() : 0;

        MessageDto dto = new MessageDto();
        dto.setId(maxCurrentId + 1);
        dto.setDateTime(LocalDateTime.now());
        dto.setFrom(item.getFrom());
        dto.setTo(item.getTo());
        dto.setText(item.getText());

        return messageDao.save(dto);
    }

    @Override
    public List<MessageDto> getMessagesForUser(String userLogin) {
        List<MessageDto> messages = new ArrayList<>();
        UserDto user = userService.get(userLogin);
        List<MessageDto> allMessages = messageDao.get();

        if (user == null) {
            return messages;
        }

        for (MessageDto message : allMessages) {
            if (message.getTo().getLogin() == userLogin) {
                messages.add(message);
            }
        }
        return messages;
    }

    @Override
    public List<MessageDto> getMessagesUser(String userLogin) {
        List<MessageDto> messages = new ArrayList<>();
        UserDto user = userService.get(userLogin);
        List<MessageDto> allMessages = messageDao.get();

        if (user == null) {
            return messages;
        }

        for (MessageDto message : allMessages) {
            if (Objects.equals(message.getFrom().getLogin(), userLogin)) {
                messages.add(message);
            }
        }
        return messages;
    }

    @Override
    public void setService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public List<MessageDto> getMessagesForUsers(String currentUserLogin, String recipientUserLogin) {
        UserDto currentUser = userService.get(currentUserLogin);
        UserDto recipientUser = userService.get(recipientUserLogin);

        if (currentUser == null || recipientUser == null) {
            return Collections.emptyList();
        }

        List<MessageDto> allMessages = messageDao.get();
        List<MessageDto> filteredMessages = new ArrayList<>();

        for (MessageDto message : allMessages) {
            if ((message.getFrom().getLogin() == currentUserLogin
                    && message.getTo().getLogin() == recipientUserLogin) ||
                    (message.getFrom().getLogin() == recipientUserLogin
                            && message.getTo().getLogin() == currentUserLogin)) {
                filteredMessages.add(message);
            }
        }

        Collections.sort(filteredMessages, Comparator.comparing(MessageDto::getDateTime));
        return filteredMessages;
    }

    @Override
    public void delete(int id) {
        messageDao.delete(id);
    }
}
