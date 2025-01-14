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
    <title>Confirmation</title>
</head>
<body>
<h1>Confirmation Page</h1>
<p><strong>Account ID:</strong> ${account.user_id}</p>
<p><strong>Name:</strong> ${account.name}</p>
<p><strong>Email:</strong> ${account.email}</p>
<p><strong>Amount:</strong> ${account.balance}</p>
<button onclick="location.href='/'">Return to Home</button>
</body>
</html>