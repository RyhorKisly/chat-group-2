package org.example.chat_group_2.web.servlets.ui;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.chat_group_2.core.dto.UserDto;

import java.io.IOException;

@WebServlet(urlPatterns = "/ui")
public class UiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDto dto = (UserDto) session.getAttribute("user");
        if(dto == null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Ui.jsp");
            requestDispatcher.forward(req, resp);
        } else {
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
            req.setAttribute("user", dto);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/UiForUsers.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

}
