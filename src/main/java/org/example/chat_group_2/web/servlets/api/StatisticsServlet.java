package org.example.chat_group_2.web.servlets.api;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.chat_group_2.dao.api.IMessageDao;
import org.example.chat_group_2.dao.api.IUserDao;
import org.example.chat_group_2.dao.memory.MessageMemoryDao;
import org.example.chat_group_2.dao.memory.UserMemoryDao;

import java.io.IOException;

@WebServlet(name = "StatisticsServlet", urlPatterns = "/api/admin/statistics")
public class StatisticsServlet extends HttpServlet {

    private final IUserDao userDao = new UserMemoryDao();
    private final IMessageDao messageDao = new MessageMemoryDao();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        int activeUserCount = (int) getServletContext().getAttribute("activeUserCount");
        int totalUserCount = userDao.get().size();
        int totalMessageCount = messageDao.get().size();

        String statistics = "Active User Count: " + activeUserCount + "\n"
                + "Total User Count: " + totalUserCount + "\n"
                + "Total Message Count: " + totalMessageCount;
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().println(statistics);
    }
}
