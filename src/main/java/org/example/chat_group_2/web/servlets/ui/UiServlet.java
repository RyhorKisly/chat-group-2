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

@WebServlet(urlPatterns = "/ui")
public class UiServlet extends HttpServlet {
    private final IUserService userService;
    public UiServlet() {
        userService = UserServiceFactory.getInstance();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDto dto = (UserDto) session.getAttribute("user");
        if(dto == null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Ui.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            List<UserDto> users = userService.get();
            req.setAttribute("users", users);
            req.setAttribute("user", dto);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/UiForUsers.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDto dto = (UserDto) session.getAttribute("user");
        if(dto == null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Ui.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            List<UserDto> users = userService.get();
            req.setAttribute("users", users);
            req.setAttribute("user", dto);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/UiForUsers.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

}
