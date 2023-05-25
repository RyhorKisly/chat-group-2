package org.example.chat_group_2.web.servlets.api;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.chat_group_2.dao.api.IMessageDao;
import org.example.chat_group_2.dao.api.IUserDao;
import org.example.chat_group_2.dao.memory.factory.MessageDaoFactory;
import org.example.chat_group_2.dao.memory.factory.UserDaoFactory;

import java.io.IOException;

@WebServlet(name = "StatisticsServlet", urlPatterns = "/api/admin/statistics")
public class StatisticsServlet extends HttpServlet {

    private final IUserDao userDao = UserDaoFactory.getInstance();
    private final IMessageDao messageDao = MessageDaoFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        ServletContext servletContext = getServletContext();

        Integer activeUserCount = (Integer) servletContext.getAttribute("activeUserCount");

        int totalUserCount = userDao.get().size();

        int totalMessageCount = messageDao.get().size();

        req.setAttribute("activeUserCount", activeUserCount);
        req.setAttribute("totalUserCount", totalUserCount);
        req.setAttribute("totalMessageCount", totalMessageCount);

        req.getRequestDispatcher("/jsp/Statistics.jsp").forward(req, resp);
    }
}
