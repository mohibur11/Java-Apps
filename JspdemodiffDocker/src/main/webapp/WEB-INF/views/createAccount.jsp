<%--
  Created by IntelliJ IDEA.
  User: mohibur
  Date: 12/11/2024
  Time: 7:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Account</title>
</head>
<body>
<h1>Create a New Account</h1>
<form action="/create" method="post">
    <label for="id">User Id:</label>
    <input type="text" id="id" name="user_id" required><br><br>
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br><br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>
    <label for="amount">Amount:</label>
    <input type="number" id="amount" name="balance" required><br><br>
    <button type="submit">Submit</button>
</form>
</body>
</html>