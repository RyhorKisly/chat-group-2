package org.example.chat_group_2.web.listeners;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class ActiveUserListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        Integer activeUserCount = (Integer) servletContext.getAttribute("activeUserCount");
        if (activeUserCount == null) {
            activeUserCount = 1;
        } else {
            activeUserCount++;
        }
        servletContext.setAttribute("activeUserCount", activeUserCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        Integer activeUserCount = (Integer) servletContext.getAttribute("activeUserCount");
        if (activeUserCount != null && activeUserCount > 0) {
            activeUserCount--;
            servletContext.setAttribute("activeUserCount", activeUserCount);
        }
    }

}

