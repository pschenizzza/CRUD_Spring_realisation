<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <div align="center" style="margin-top: 30px">
        <title>Registration</title>
        <h3>Registration</h3>
    </div>
</head>
<body>
<c:url value="/registration" var="var"/>
<div align="center">
    <form action="${var}" method="POST">

        <label for="login">Login</label>
        <input type="text" name="login" id="login">

        <label for="password">Password</label>
        <input type="text" name="password" id="password">

        <input type="submit" value="Registration">
    </form>
    <style> a {text-decoration: none;}</style>
    <a href="<c:url value="/login" />">Login</a>
</div>
</body>
</html>