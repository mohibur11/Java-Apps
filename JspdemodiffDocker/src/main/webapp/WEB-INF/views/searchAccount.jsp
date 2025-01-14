<%--
  Created by IntelliJ IDEA.
  User: mohibur
  Date: 12/11/2024
  Time: 7:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Account</title>
</head>
<body>
<h1>Search Account</h1>
<form action="/search" method="post">
    <label for="id">Account ID:</label>
    <input type="string" id="id" name="id" required><br><br>
    <button type="submit">Search</button>
</form>
</body>
</html>