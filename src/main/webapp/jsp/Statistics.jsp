<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Statistics</title>
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/ui">Home</a></li>
                    <li style="float: right;"><a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/ui/signIn">Вход</a></li>

                <li style="float: right;"><a href="http://localhost:8081/chat-group-2-1.0-SNAPSHOT/ui/signUp">Регистрация</a></li>
                  <!-- <li style="float: right;"><span>Login: guest Role: unknown</span></li> -->
        </ul>
    </nav>
</header>
    <h1>Statistics</h1>
    <table>
        <tr>
            <th>Active User Count:</th>
            <td>${activeUserCount}</td>
        </tr>
        <tr>
            <th>Total User Count:</th>
            <td>${totalUserCount}</td>
        </tr>
        <tr>
            <th>Total Message Count:</th>
            <td>${totalMessageCount}</td>
        </tr>
    </table>
</body>
</html>
