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
    <title>Error</title>
</head>
<body>
<h1>Error Occurred</h1>
<button onclick="location.href='/'">Return to Home</button>
<p>${error}</p>
<p>${requestScope}</p>
<%=request %>
<%=response %>
</body>
</html>