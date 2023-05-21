package org.example.chat_group_2.web.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.chat_group_2.core.dto.UserDto;

import java.io.IOException;

@WebFilter(urlPatterns = {"/ui/admin/*", "/api/admin/*"})
public class AdminSecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        UserDto user = (UserDto) session.getAttribute("user");
        if((session!=null) && (user !=null)){
            if (user.getLogin().equals("Admin") && user.getPassword().equals("Admin")){
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
            res.sendRedirect(contextPath + "/");
            }
        } else {
            res.sendRedirect(contextPath + "/signIn");
        }
    }
}
