<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <div align="center" style="margin-top: 30px">
        <title>Add user</title>
        <h3>Add user</h3>
    </div>
</head>
<body>
<c:url value="/admin/addUser" var="var"/>
<div align="center">
    <form action="${var}" method="POST">
        <input type="hidden" name="id" value="${user.id}">

        <label for="login">Login</label>
        <input type="text" name="login" id="login">

        <label for="password">Password</label>
        <input type="text" name="password" id="password">

        <input type="submit" value="Add user">
    </form>
    <style> a {text-decoration: none;}</style>
    <a href="<c:url value="/logout" />">Logout</a>
    <a href="<c:url value="/admin/users" />">Users</a>
</div>
</body>
</html>
