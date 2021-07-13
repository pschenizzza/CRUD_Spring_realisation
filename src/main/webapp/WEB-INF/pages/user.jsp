<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Hello</title>
</head>
<body>
<div align="center" style="margin-top: 30px">
  <h2>Hello, ${user.login}!</h2>

  <table border="1" width="40%" cellpadding="5">
    <colgroup>
      <col span="6" style="background:darkgray">
    </colgroup>
    <tr>
      <th>Login</th>
      <th>Password</th>
      <th>Role(s)</th>
    </tr>
    <tr>
      <td align="center">${user.login}</td>
      <td>${user.password}</td>
      <td><c:forEach var="role" items="${user.roles}">
        <p>${role.name}</p>
      </c:forEach>
      </td>
    </tr>
  </table>

  <a href="<c:url value="/logout" />">Logout</a>
</div>
</body>
</html>

