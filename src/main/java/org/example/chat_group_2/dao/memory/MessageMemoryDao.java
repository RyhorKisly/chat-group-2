package org.example.chat_group_2.dao.memory;

import org.example.chat_group_2.core.dto.MessageDto;
import org.example.chat_group_2.dao.api.IMessageDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageMemoryDao implements IMessageDao {
    private final Map<Integer, MessageDto> message = new HashMap<>();
    public MessageMemoryDao() {
    }

    @Override
    public List<MessageDto> get() {
        return new ArrayList<>(this.message.values());
    }

    @Override
    public MessageDto get(int id) {
        return this.message.get(id);
    }

    @Override
    public MessageDto save(MessageDto item) {
        this.message.put(item.getId(), item);
        return item;
    }
}
