package org.example.chat_group_2.web.servlets.ui;

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
import java.util.List;

@WebServlet(urlPatterns = "/ui/signUp")
public class UiSignUpServlet extends HttpServlet {
    private final IUserService userService;
    public UiSignUpServlet() {
        userService = UserServiceFactory.getInstance();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDto dto = (UserDto) session.getAttribute("user");
        RequestDispatcher requestDispatcher;
        if(dto == null) {
            String login = (String) session.getAttribute("loginOuter");
            session.removeAttribute("loginOuter");
            req.setAttribute("loginOuter", login);
            requestDispatcher = req.getRequestDispatcher("/SignUp.jsp");
        } else {
            requestDispatcher = req.getRequestDispatcher("/ui/user");
        }
        requestDispatcher.forward(req, resp);
    }
}
