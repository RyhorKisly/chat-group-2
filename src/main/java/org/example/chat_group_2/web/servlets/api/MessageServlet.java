package org.example.chat_group_2.web.servlets.api;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.chat_group_2.core.dto.MessageCreateDto;
import org.example.chat_group_2.core.dto.MessageDto;
import org.example.chat_group_2.core.dto.UserDto;
import org.example.chat_group_2.service.api.IMessageService;
import org.example.chat_group_2.service.api.IUserService;
import org.example.chat_group_2.service.factory.MessageServiceFactory;
import org.example.chat_group_2.service.factory.UserServiceFactory;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/api/message")
public class MessageServlet extends HttpServlet {
    private static final String TO_PARAM_NAME = "to";
    private static final String TEXT_PARAM_NAME = "text";
    private static final String USER_SESSION_ATTRIBUTE_NAME = "user";
    private final IMessageService messageService;
    private final IUserService userService;

    public MessageServlet() {
        this.messageService = MessageServiceFactory.getInstance();
        this.userService = UserServiceFactory.getInstance();
        this.messageService.setService(userService);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        UserDto currentUser = (UserDto) session.getAttribute(USER_SESSION_ATTRIBUTE_NAME);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        if ("out".equals(req.getParameter("param"))) {
            List<MessageDto> userMessages = messageService.getMessagesUser(currentUser.getLogin());
            session.setAttribute("formatter", formatter);
            session.setAttribute("userMessages", userMessages);
            resp.sendRedirect(req.getContextPath() + "/ui/user/chats/out");
        } else {
            List<MessageDto> userMessages = messageService.getMessagesForUser(currentUser.getLogin());
            session.setAttribute("formatter", formatter);
            session.setAttribute("userMessages", userMessages);
            resp.sendRedirect(req.getContextPath() + "/ui/user/chats");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        UserDto currentUser = (UserDto) session.getAttribute(USER_SESSION_ATTRIBUTE_NAME);

        String toUsername = req.getParameter(TO_PARAM_NAME);
        String messageText = req.getParameter(TEXT_PARAM_NAME);

        if (toUsername == null || toUsername.isEmpty() || messageText == null || messageText.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "To or text fields are empty");
            return;
        }

        UserDto recipient = userService.findByLogin(toUsername);
        if (recipient == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Recipient with such username does not exist");
            return;
        }

        MessageCreateDto messageToSave = new MessageCreateDto(currentUser, recipient, messageText);
        messageService.save(messageToSave);

        resp.setStatus(HttpServletResponse.SC_CREATED); // HTTP status 201
        resp.sendRedirect(req.getContextPath() + "/ui/user/message");
    }
}
