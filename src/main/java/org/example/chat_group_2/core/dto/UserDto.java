package org.example.chat_group_2.core.dto;

public class UserDto {
    private String login;
    private String password;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String birthDay;
    private String registrationDay;
    private String role;

    public UserDto() {

    }

    public UserDto(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public UserDto(String login, String passWord, String lastName, String firstName, String patronymic, String birthDay, String registrationDay, String role) {
        this.login = login;
        this.password = passWord;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String passWord) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
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
