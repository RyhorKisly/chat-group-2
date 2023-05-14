package org.example.chat_group_2.web.servlets.api;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "LoginServlet", urlPatterns = "/api/login ")
public class LoginServlet extends HttpServlet {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";

    List<UserDTO> userList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        getUserLogin(List<UserDTO> userList,HttpServletRequest req, HttpServletResponse resp);

    }
    void getUserLogin(List<UserDTO> userList,HttpServletRequest req, HttpServletResponse resp){

        PrintWriter writer = null;

        try {
            writer = resp.getWriter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        UserDTO currentUser = null;

        String loginValue = req.getParameter(LOGIN);
        String passwordValue = req.getParameter(PASSWORD);

        for (UserDTO user : userList) {
            if (user.getLogin.equals(loginValue)) {
                currentUser = user;
            } else {
                writer.write("ошибка. нет такого юзера");
            }
        }
        if (currentUser.getPassword.equals(passwordValue)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", currentUser);
        } else {
            writer.write("ввели неверный пароль");
        }
    }
}