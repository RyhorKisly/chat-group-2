package org.example.chat_group_2.core.dto;

import java.time.LocalDateTime;

public class MessageDto {
    private int id;

    private LocalDateTime dateTime;
    private UserDto from;
    private UserDto to;
    private String letter;

    public MessageDto() {
    }

    public MessageDto(int id, LocalDateTime dateTime, UserDto from, UserDto to, String text) {
        this.id = id;
        this.dateTime = dateTime;
        this.from = from;
        this.to = to;
        this.letter = text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
