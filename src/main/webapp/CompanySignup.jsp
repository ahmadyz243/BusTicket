<%--
  Created by IntelliJ IDEA.
  User: Rayan system
  Date: 8/27/2022
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Signup as Company</title>
</head>
<body>
    <form action="http://localhost:8080/OnlineTicketWebApp_war_exploded/companysignup" method="post" name="company-signup-form">
        <input type="text" name="companyname" placeholder="company name" required><br>
        <input type="text" name="companyusername" placeholder="username" required><br>
        <input type="password" name="companypassword" placeholder="password" required><br>
        <input type="password" name="companypasswordrepeat" placeholder="repeat password" required><br>
        <input type="submit" value="signup"><br>
    </form>
    <% Boolean wrongRepeat = (Boolean) request.getAttribute("wrongRepeat");
    Boolean duplicateUsername = (Boolean) request.getAttribute("duplicateUsername");
        if(wrongRepeat != null && wrongRepeat){ %>
            <p class="msg">repeat password carefully</p>
    <% } else if(duplicateUsername != null && duplicateUsername){ %>
            <p class="msg">this username already exists!!!</p>
    <% } %>
</body>
</html>
