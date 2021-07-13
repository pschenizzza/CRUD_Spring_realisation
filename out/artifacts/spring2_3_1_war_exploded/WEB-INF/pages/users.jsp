<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <div align="center">
    <title>Users</title>
    <h2>Users</h2>
    </div>
</head>
<body>
<div align="center">
<style> a {text-decoration: none;}</style>
<table border="1" cellpadding="5">
    <tr>
        <th>№</th>
        <th>Name</th>
        <th>Password</th>
        <th>Email</th>
        <th>Action</th>
    </tr>
<c:forEach var="tmp" items="${userList}">
    <tr>
        <td align="center">${tmp.id}</td>
        <td>${tmp.name}</td>
        <td>${tmp.password}</td>
        <td>${tmp.email}</td>
        <td>
        <a href="/edit/${tmp.id}">Edit</a>
        <a href="/delete/${tmp.id}">Delete</a>
        </td>
    </tr>
</c:forEach>
</table>
<br>
<c:url value="/adduser" var="add"/>
<a href="${add}">Add new user</a>
</div>
</body>
</html>
