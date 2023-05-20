package org.example.chat_group_2.web.servlets.ui;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.chat_group_2.core.dto.UserDto;
import org.example.chat_group_2.service.UserService;
import org.example.chat_group_2.service.factory.UserServiceFactory;

import java.io.IOException;
import java.util.List;

@WebServlet("/ui/user/message")
public class MessageUIServlet extends HttpServlet {
    private static final String USER_SESSION_ATTRIBUTE_NAME = "user";
    private UserService userService = (UserService) UserServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        UserDto user = null;

        if (session != null) {
            Object userObj = session.getAttribute(USER_SESSION_ATTRIBUTE_NAME);
            if (userObj instanceof UserDto) {
                user = (UserDto) userObj;
            }
        }

        if (user != null) {
            List<UserDto> users = userService.get();
            users.remove(user);
            req.setAttribute("user", user);
            req.setAttribute("users", users);
            req.getRequestDispatcher("/ui/user/message.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/");
        }
    }
}
