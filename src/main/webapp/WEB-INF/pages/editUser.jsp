<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <div align="center" style="margin-top: 30px">
        <title>Edit user</title>
        <h3>Edit user</h3>
    </div>
</head>
<body>
<c:url value="/admin/edit" var="var"/>
<div align="center">
    <form action="${var}" method="POST" >
        <input type="hidden" name="id" value="${user.id}"required>

        <label for="login">Login</label>
        <input type="text" name="login" id="login" value="${user.login}"required>

        <label for="password">Пароль</label>
        <input type="text" name="password" id="password" value="${user.password}"required>

        <input type="checkbox" name="AddAdmin" value="add">
        <label>make Admin</label>

        <input type="submit" value="Edit user">
    </form>
    <style> a {text-decoration: none;}</style>
    <a href="<c:url value="/logout" />">Logout</a>
    <a href="<c:url value="/admin/users" />">Users</a>
</div>
</body>
</html>

