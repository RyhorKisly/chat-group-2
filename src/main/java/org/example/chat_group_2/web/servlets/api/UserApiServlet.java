package org.example.chat_group_2.web.servlets.api;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.chat_group_2.core.dto.UserDto;
import org.example.chat_group_2.service.api.IUserService;
import org.example.chat_group_2.service.factory.UserServiceFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/api/user")
public class UserApiServlet extends HttpServlet {
    private final IUserService userService;
    private final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyyг. HH:mm:ss");
    private final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyyг.");
    private final static DateTimeFormatter FORMATTER_FOR_PARSING = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final String LOGIN_PARAM_NAME = "login";
    private static final String PASSWORD_PARAM_NAME = "password";
    private static final String LASTNAME_PARAM_NAME = "lastName";
    private static final String FIRSTNAME_PARAM_NAME = "firstName";
    private static final String PATRONYMIC_PARAM_NAME = "patronymic";
    private static final String BIRTHDAY_PARAM_NAME = "birthDay";
    public UserApiServlet() {
        userService = UserServiceFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDto dto = (UserDto) session.getAttribute("user");
        if(dto == null) {
            req.setAttribute("login1", "login1");
            req.setAttribute("login2", "login2");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/SignUp.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            req.setAttribute("user", dto);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/UiForUsers.jsp");
            requestDispatcher.forward(req, resp);
        }

    }

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

        UserDto dto = new UserDto(login, password,
                lastName, firstName, patronymic,
                parsedBirthDay, registrationDay,
                "User"
        );

        if(userService.get(dto.getLogin()) == null) {
            userService.save(dto);
            HttpSession session = req.getSession();
            session.setAttribute("user", dto);
            req.setAttribute("user", dto);
            List<UserDto> users = userService.get();
            req.setAttribute("users", users);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ui");
            requestDispatcher.forward(req, resp);
        } else {
            req.setAttribute("login1", dto.getLogin());
            req.setAttribute("login2", userService.get(dto.getLogin()).getLogin());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ui/signUp");
            requestDispatcher.forward(req, resp);
        }

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
