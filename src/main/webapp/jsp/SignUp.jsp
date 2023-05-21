<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style>
       <%@include file='style/signUpStyle.css' %>
    </style>
	<title>Registration form</title>
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/ui">Главная</a></li>
                    <li style="float: right;"><a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/ui/signIn">Вход</a></li>

                <li style="float: right;"><a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/ui/signUp">Регистрация</a></li>
                  <!-- <li style="float: right;"><span>Login: guest Role: unknown</span></li> -->
        </ul>
    </nav>
</header>
<form class="modal-content" action="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/api/user" method="POST">
  <c:choose>
    <c:when test="${empty loginOuter}">
          <div class="container">
            <h1>Регистрация</h1>
            <p>Пожалуйста, заполните форму для создания аккаунта.</p>
          </div>
    </c:when>
    <c:otherwise>
              <div class="container">
                <h1>Регистрация</h1>
                <p style="color:red">login: ${loginOuter}  </br>
                Уже существует. Пожалуйста, попробуй ещё!</p>
              </div>
    </c:otherwise>
  </c:choose>
  <hr>
  <div class="container-form">
    <label for="login"><b>Логин</b></label>
    <input type="text" placeholder="Введите логин" name="login" required>

    <label for="password"><b>Пароль</b></label>
    <input type="password" placeholder="Введите пароль" name="password" required>

    <label for="lastName"><b>Фамилия</b></label>
    <input type="text" placeholder="Введите Фамилию" name="lastName" required>

    <label for="firstName"><b>Имя</b></label>
    <input type="text" placeholder="Введите Имя" name="firstName" required>

        <label for="patronymic"><b>Отчество</b></label>
    <input type="text" placeholder="Введите Отчество" name="patronymic" required>

    <label for="birthDay"><b>Введите дату рождения</b></label>
    <input type="date" id="Bday" name="birthDay" min="1967-01-01" max="2018-12-31" required>
    <hr>

    <button type="submit" class="registerbtn">Регистрация</button>
  </div>
  <div class="container signin">
    <p>Уже есть аккаунт? <a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/api/login">Вход</a>.</p>
  </div>
  </form>

</body>
</html>