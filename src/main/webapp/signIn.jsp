<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style>
       <%@include file='/styleForUserSignUp.css' %>
    </style>
	<title>Authorization form</title>
</head>
<body>
<form class="modal-content" action="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/api/login" method="POST">
  <hr>
  <div class="container-form">
    <label for="login"><b>Login</b></label>
    <input type="text" placeholder="Введите login" name="login" required>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Введите пароль" name="password" required>

    <hr>

    <button type="submit" class="registerbtn">Войти</button>
  </div>
  <div class="container signin">
    <p><a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/ui/signUp">Вернуться к регистрации</a></p>
  </div>
  </form>

</body>
</html>