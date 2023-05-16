package org.example.chat_group_2.web.servlets.api;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.chat_group_2.core.dto.UserDto;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@WebServlet(urlPatterns = "/api/user")
public class UserServlet extends HttpServlet {
    private final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyyг. HH:mm:ss");
    private final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyyг.");
    private final static DateTimeFormatter FORMATTER_FOR_PARSING = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final String LOGIN_PARAM_NAME = "login";
    private static final String PASSWORD_PARAM_NAME = "password";
    private static final String LASTNAME_PARAM_NAME = "lastName";
    private static final String FIRSTNAME_PARAM_NAME = "firstName";
    private static final String PATRONYMIC_PARAM_NAME = "patronymic";
    private static final String BIRTHDAY_PARAM_NAME = "birthDay";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        Map<String, String[]> parameterMap = req.getParameterMap();
        String login = verifyAndAddParam(LOGIN_PARAM_NAME, parameterMap);
        String password = verifyAndAddParam(PASSWORD_PARAM_NAME, parameterMap);
        String lastName = verifyAndAddParam(LASTNAME_PARAM_NAME, parameterMap);
        String firstName = verifyAndAddParam(FIRSTNAME_PARAM_NAME, parameterMap);
        String patronymic = verifyAndAddParam(PATRONYMIC_PARAM_NAME, parameterMap);

        String registrationDay = DATE_TIME_FORMATTER.format(LocalDateTime.now());

        String birthDay = verifyAndAddParam(BIRTHDAY_PARAM_NAME, parameterMap);
        LocalDate date = LocalDate.parse(birthDay, FORMATTER_FOR_PARSING);
        String parsedBirthDay = DATE_FORMATTER.format(date);


        UserDto dto = new UserDto(
                login,
                password,
                lastName,
                firstName,
                patronymic,
                parsedBirthDay,
                registrationDay,
                "User"
        );



        writer.write("<p>" + dto.getLogin() + "</p>" +
                        "<p>" + dto.getLogin() + "</p>" +
                        "<p>" + dto.getPassword() + "</p>" +
                        "<p>" + dto.getLastName() + "</p>" +
                        "<p>" + dto.getFirstName() + "</p>" +
                        "<p>" + dto.getPatronymic() + "</p>" +
                        "<p>" + dto.getBirthDay() + "</p>" +
                        "<p>" + dto.getRegistrationDay() + "</p>" +
                        "<p>" + dto.getRole() + "</p>"
                );



    }



    private String verifyAndAddParam(String paramName, Map<String, String[]> parameterMap) {
        String[] paramRaw = parameterMap.get(paramName);
        if(paramRaw.length > 1) {
            throw new IllegalArgumentException("Слишком много параметров");
        }
        String param = null;
        if(paramRaw.length == 1) {
            param = paramRaw[0];
        }
        return param;
    }
}
