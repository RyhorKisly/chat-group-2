package org.example.chat_group_2.web.servlets.api;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.chat_group_2.service.api.IUserService;
import org.example.chat_group_2.service.factory.UserServiceFactory;

import java.io.IOException;
import java.io.PrintWriter;


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

        String loginValue = req.getParameter(LOGIN_PARAM_NAME);
        String passwordValue = req.getParameter(PASSWORD_PARAM_NAME);

        PrintWriter writer = resp.getWriter();

        if (userService.get(loginValue) != null) {
            if (userService.get(loginValue).getLogin().equals(loginValue) && userService.get(loginValue).getPassword().equals(passwordValue)){
                HttpSession session = req.getSession();
                session.setAttribute("user", userService.get(loginValue));
                resp.sendRedirect(req.getContextPath() + "/ui");
//                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ui");
//                requestDispatcher.forward(req, resp);
            } else{
                writer.write("<p>Password is incorrect</p>");
            }
        } else {
            writer.write("<p>Login not found. Sign up please</p>");
        }
    }
}