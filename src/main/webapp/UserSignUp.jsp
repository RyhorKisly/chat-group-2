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
	<title>Registration form</title>
</head>
<body>
<form class="modal-content" action="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/api/user" method="POST">
  <c:choose>
    <c:when test="${loginBoolean == false}">
      <div class="container">
        <h1>Registration</h1>
        <p>Please fill in this form to create an account.</p>
      </div>
    </c:when>
    <c:otherwise>
      <div class="container">
        <h1>Registration</h1>
        <p style="color:red">login: ${login}  </br>
        already exists. Please, try again!</p>
      </div>
    </c:otherwise>
  </c:choose>
  <hr>
  <div class="container-form">
    <label for="login"><b>Login</b></label>
    <input type="text" placeholder="Введите login" name="login" required>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Введите пароль" name="password" required>

    <label for="lastName"><b>LastName</b></label>
    <input type="text" placeholder="Введите Фамилию" name="lastName" required>

    <label for="firstName"><b>FirstName</b></label>
    <input type="text" placeholder="Введите Имя" name="firstName" required>

        <label for="patronymic"><b>Patronymic</b></label>
    <input type="text" placeholder="Введите Отчество" name="patronymic" required>

    <label for="birthDay"><b>Enter Birthday</b></label>
    <input type="date" id="Bday" name="birthDay" min="1967-01-01" max="2018-12-31" required>
    <hr>

    <button type="submit" class="registerbtn">Sign up</button>
  </div>
  <div class="container signin">
    <p>Already have an account? <a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/api/login">Sign in</a>.</p>
  </div>
  </form>

</body>
</html>