package org.example.chat_group_2.core.dto;

public class UserDto {
//    hello
    private String login;
    private String passWord;
    private String fullName;
    private String birthDay;
    private String registrationDay;
    private String role;
    public UserDto() {

    }

    public UserDto(String login, String passWord, String fullName, String birthDay, String registrationDay, String role) {
        this.login = login;
        this.passWord = passWord;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.registrationDay = registrationDay;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getRegistrationDay() {
        return registrationDay;
    }

    public void setRegistrationDay(String registrationDay) {
        this.registrationDay = registrationDay;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
