<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style>
       <%@include file='/jsp/style/message.css' %>
       <%@include file='/jsp/style/style.css' %>
    </style>
	<title>Исходящие сообщения</title>
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/ui">Home</a></li>
            <li><a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/ui/user/message">Messages</a></li>
            <li><a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/ui/user/chats">Chats</a></li>
                <li style="float: right;"><a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/api/signOut">Sign Out</a></li>
                <li style="float: right;"><span>${user.role}: ${user.login}</span></li>
        </ul>
    </nav>
</header>

<c:if test="${not empty user}">
    <a href="${pageContext.request.contextPath}/ui/user" class="back-button">Назад</a>
    <form method="post" action="${pageContext.request.contextPath}/api/message" class="message-form">
        <label for="to">Кому:</label>
        <select id="to" name="to" required>
            <option value="">Выберите получателя</option>
            <c:forEach items="${users}" var="recipient">
                <option value="${recipient.login}"<c:if test="${recipient.login == param.to}"> selected</c:if>>${recipient.login}</option>
            </c:forEach>
        </select>

        <label for="text">Текст сообщения:</label>
        <textarea id="text" name="text" placeholder="Введите текст сообщения" required></textarea>

        <input type="submit" value="Отправить">
    </form>
</c:if>

</body>
</html>