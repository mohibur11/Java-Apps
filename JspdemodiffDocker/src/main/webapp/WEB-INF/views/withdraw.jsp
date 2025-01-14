<%--
  Created by IntelliJ IDEA.
  User: mohibur
  Date: 12/11/2024
  Time: 7:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Withdraw</title>
</head>
<body>
<h1>Withdraw Money</h1>
<form action="/withdraw" method="post">
    <label for="id">Account ID:</label>
    <input type="number" id="id" name="id" required><br><br>
    <label for="amount">Withdraw Amount:</label>
    <input type="number" id="amount" name="amount" required><br><br>
    <button type="submit">Withdraw</button>
</form>
</body>
</html>
