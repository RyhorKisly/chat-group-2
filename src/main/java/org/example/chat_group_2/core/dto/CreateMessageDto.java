package org.example.chat_group_2.core.dto;

public class CreateMessageDto {
    private UserDto from;
    private UserDto to;
    private String letter;

    public CreateMessageDto(UserDto from, UserDto to, String letter) {
        this.from = from;
        this.to = to;
        this.letter = letter;
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

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
}
