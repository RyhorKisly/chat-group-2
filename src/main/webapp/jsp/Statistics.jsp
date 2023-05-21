<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Statistics</title>
</head>
<body>
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
