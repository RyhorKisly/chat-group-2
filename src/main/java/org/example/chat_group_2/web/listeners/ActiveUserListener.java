package org.example.chat_group_2.web.listeners;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class ActiveUserListener implements HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void sessionCreated(HttpSessionEvent e) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent e) {
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if (event.getName().equals("user")) {
            ServletContext servletContext = event.getSession().getServletContext();
            int activeUserCount = (int) servletContext.getAttribute("activeUserCount");
            servletContext.setAttribute("activeUserCount", activeUserCount + 1);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if (event.getName().equals("user")) {
            ServletContext servletContext = event.getSession().getServletContext();
            int activeUserCount = (int) servletContext.getAttribute("activeUserCount");
            servletContext.setAttribute("activeUserCount", activeUserCount - 1);
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
    }
}

