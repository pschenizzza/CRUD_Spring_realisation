<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <div align="center">
    <title>Add user</title>
    <h3>Add user</h3>
    </div>
</head>
<body>
<c:url value="/adduser" var="var"/>
    <div align="center">
        <form action="${var}" method="POST">
            <input type="hidden" name="id" value="${user.id}">

            <label for="name">Имя</label>
            <input type="text" name="name" id="name">

            <label for="password">Пароль</label>
            <input type="text" name="password" id="password">

            <label for="email">Email</label>
            <input type="text" name="email" id="email">

            <input type="submit" value="Add user">
        </form>
    <style> a {text-decoration: none;}</style>
    <a href="/">To main page</a>
    </div>
</body>
</html>
