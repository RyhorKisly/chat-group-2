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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = "/api/login")
public class LoginServlet extends HttpServlet {

    private static final String LOGIN_PARAM_NAME = "login";
    private static final String PASSWORD_PARAM_NAME = "password";

    private final IUserService userService;

    public LoginServlet() {
        userService = UserServiceFactory.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        List<UserDto> userList = userService.get();

        String loginValue = req.getParameter(LOGIN_PARAM_NAME);
        String passwordValue = req.getParameter(PASSWORD_PARAM_NAME);

        PrintWriter writer = resp.getWriter();

        for (UserDto user : userList) {
            if (user.getLogin().equals(loginValue) && user.getPassword().equals(passwordValue)) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ui/user/message");
                requestDispatcher.forward(req, resp);
            } else {
                writer.write("<p>Login or password is incorrect</p>");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ui");
                requestDispatcher.forward(req, resp);
            }
        }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/signIn.jsp");
        requestDispatcher.forward(req, resp);
    }
}