<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <div align="center">
    <title>Edit user</title>
    <h3>Edit user</h3>
    </div>
</head>
<body>
<c:url value="/edit" var="var"/>
<div align="center">

    <form action="${var}" method="POST">
        <input type="hidden" name="id" value="${user.id}"required>

        <label for="name">Имя</label>
        <input type="text" name="name" id="name" value="${user.name}"required>

        <label for="password">Пароль</label>
        <input type="text" name="password" id="password" value="${user.password}"required>

        <label for="email">Email</label>
        <input type="text" name="email" id="email" value="${user.email}"required>

        <input type="submit" value="Edit user">

    </form>
    <style> a {text-decoration: none;}</style>
    <a href="/">To main page</a>
</div>
</body>
</html>

