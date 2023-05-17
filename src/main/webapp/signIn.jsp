<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
    <head>
     <meta charset="utf-8">
     <meta name="viewport" content="width=device-width, initial-scale=1">
     <title>Вход в чат</title>
  </head>
 <body>
  <form action="http://http://localhost:8081/chat-group-2-1.0-SNAPSHOT/api/login" method="POST">
   <p><strong>Логин:</strong>
    <input maxlength="25" size="40" name="login"></p>
   <p><strong>Пароль:</strong>
    <input type="password" maxlength="25" size="40" name="password"></p>
    <p><input type="submit" value="Войти"></p>
    <a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/ui/signUp">Перейти к регистрации</a>
  </form>
  </body>
</html>

