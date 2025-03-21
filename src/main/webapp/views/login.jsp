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
    <title>Login</title>
</head>
<body>
  <form action="login" method="post">
    Email: <input type="text" name="email" required><br>
    Password: <input type="password" name="password" required><br>
    <button type="submit">Login</button>
  </form>
  <%
    String error = request.getParameter("error");
    String message = request.getParameter("message");
  %>
  <% if ("invalid".equals(error)) { %>
  <p style="color: red;">Sai email hoặc mật khẩu. Vui lòng thử lại!</p>
  <% } %>
  <% if ("success".equals(message)) { %>
  <p style="color: green;">Đăng ký thành công! Bạn có thể đăng nhập ngay.</p>
  <% } %>
</body>
</html>
