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
	<title>Главная</title>
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="/chat-project-1.0.0/ui/">Home</a></li>
            <li><a href="/chat-project-1.0.0/ui/user/message">Messages</a></li>
            <li><a href="/chat-project-1.0.0/ui/user/chats">Chats</a></li>
                    <li style="float: right;"><a href="/chat-project-1.0.0/ui/signIn">Sign In</a></li>

                <li style="float: right;"><a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/ui/signUp">Registration</a></li>
                  <!-- <li style="float: right;"><span>Login: guest Role: unknown</span></li> -->
        </ul>
    </nav>
</header>
<div class="modal-content">
  <div class="container">

    <p>Привет странник. </br>
    Это главная страница нашего уникального мессендржера. </br>
  Ты можешь в полную наслаждаться функционалом данной страницы и оценить возможности приложения. </br>
  Надеюсь ты получишь поистине великое удовольствие! </br></br>
  Тебе необходимо ввойти в аккаунт или пройти регистрацию</p>
  </div>
  <hr>
  <div class="container signin">
    <p><a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/ui/signIn">Sign In</a></p>
  </div>
    <div class="container signin">
    <p><a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/ui/signUp">Registration</a></p>
  </div>
  </div>

</body>
</html>