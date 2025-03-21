<%--
  Created by IntelliJ IDEA.
  User: ngocq
  Date: 3/21/2025
  Time: 5:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
  <form action="register" method="post">
    Email: <input type="text" name="email" required><br>
    Password: <input type="password" name="password" required><br>
    <button type="submit">Register</button>
  </form>
  <% String error = request.getParameter("error"); %>
  <% if ("failed".equals(error)) { %>
  <p style="color: red;">Đăng ký thất bại. Vui lòng thử lại.</p>
  <% } %>
</body>
</html>
