<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style>
       <%@include file='/styleForUi.css' %>
    </style>
	<title>Registration form</title>
</head>
<body>
<div class="modal-content">
  <div class="container">
    <p>Привет странник. </br>
    Это главная страница нашего уникального мессендржера. </br>
  Ты можешь в полную наслаждаться функционалом данной страницы и оценить возможности приложения. </br>
  Надеюсь ты получишь поистине великое удовольствие!</p>
  </div>
  <hr>
  <div class="container signin">
    <p>Уже есть аккаунт? Тогда - <a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/ui/signIn">Sign in</a>.</p>
  </div>
    <div class="container signin">
    <p>Ещё нет? Дерзай на <a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/ui/signUp">регистрацию</a>.</p>
  </div>
  </div>

</body>
</html>