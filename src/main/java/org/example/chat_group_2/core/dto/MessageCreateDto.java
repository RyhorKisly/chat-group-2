package org.example.chat_group_2.core.dto;

public class MessageCreateDto {
    private UserDto from;
    private UserDto to;
    private String text;

    public MessageCreateDto(UserDto from, UserDto to, String letter) {
        this.from = from;
        this.to = to;
        this.text = letter;
    }

    public UserDto getFrom() {
        return from;
    }

    public void setFrom(UserDto from) {
        this.from = from;
    }

    public UserDto getTo() {
        return to;
    }

    public void setTo(UserDto to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String letter) {
        this.text = letter;
    }
}
