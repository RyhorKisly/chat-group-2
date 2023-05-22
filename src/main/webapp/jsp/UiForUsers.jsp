<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style>
       <%@include file='style/uiStyle.css' %>
    </style>
	<title>Главная</title>
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/ui/user">Главная</a></li>
            <li><a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/ui/user/message">Сообщения</a></li>
            <li><a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/ui/user/chats">Чат</a></li>
  <c:choose>
    <c:when test="${user.role == 'Admin'}">
    <li><a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/api/admin/statistics">Статистика</a></li>
    </c:when>
  </c:choose>
                    <li style="float: right;"><a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/api/signOut">Выход</a></li>
                  <li style="float: right;"><span>${user.role}: ${user.login}</span></li>
        </ul>
    </nav>
</header>
<div class="main">
    <div>
        <h1>Привет, ${user.login}!</h1>
        <p>Админ всегда на связи!</p>
        <h3>Список пользователей</h3>
        <lu type="none">
            <hr/>
            <c:forEach items="${users}" var="user1">
                <li class="wraper">
                    <div class="wraper-1">
                        <c:out value="${user1.login}"/>
                    </div>
                    <div class="wraper-2">
                        <form method="get" action="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/ui/user/message">
                            <button value=<c:out value="${user1.login}"/> name="answerLogin">Написать</button>
                        </form>
                    </div>
                </li>
                <hr/>
            </c:forEach>
        </lu>
    </div>
</div>

</body>
</html>