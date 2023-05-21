<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style>
       <%@include file='/style/libStyle.css' %>
    </style>
	<title>Исходящие сообщения</title>
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/ui">Home</a></li>
            <li><a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT//ui/user/message">Messages</a></li>
            <li><a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/ui/user/chats">Chats</a></li>
                <li style="float: right;"><a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/api/signOut">Sign Out</a></li>
                <li style="float: right;"><span>${user.role}: ${user.login}</span></li>
        </ul>
    </nav>
</header>
<a href="${pageContext.request.contextPath}/ui/user" class="back-button">Назад</a>
<main class="main">
    <div class="container"><h1 class="title">Входящие сообщения</h1>
        <div class="actions center"><a href="${pageContext.request.contextPath}/api/message" class="button">⟳
            Обновить</a></div>
        <c:if test="${not empty userMessages}"> <c:forEach items="${userMessages}" var="message">
            <div class="message">
                <div class="message__header">
                    <div class="message__recipient">
                        <div class="message__recipient-box">
                            <b>От:</b>
                        </div>
                        <p class="message__recipient-text">${message.from.userName}</p>
                    </div>
                    <p class="message__date">
                        <b></b> ${message.dateTime != null ? message.dateTime.format(formatter) : ''}</p>
                </div>
                <p class="message__text"><b></b> ${message.text}</p>
                <div class="message__actions">
                    <div class="message__form">
                        <form method="post" action="${pageContext.request.contextPath}/ui/user/message" class="form">
                            <a class="button_as"
                               href="${pageContext.request.contextPath}/ui/user/message?to=${message.from.userName}">
                                Ответить
                            </a>
                        </form>

                        <form method="POST"
                              action="${pageContext.request.contextPath}/api/message/del/${message.id}"
                              class="form"><input type="hidden" name="_method" value="DELETE"/> <input type="hidden" name="messageId" value="${message.id}"/>
                            <button type="submit" class="button_sa">Удалить</button>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach> </c:if></div>
</main>
</body>
</html>
