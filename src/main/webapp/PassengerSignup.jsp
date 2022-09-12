<%--
  Created by IntelliJ IDEA.
  User: Rayan system
  Date: 8/27/2022
  Time: 6:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Signup as Costumer</title>
</head>
<body>
    <form action="http://localhost:8080/OnlineTicketWebApp_war_exploded/passengersignup" method="post" name="passenger-signup-form">
        <input type="text" name="fname" placeholder="first name" required><br>
        <input type="text" name="lname" placeholder="last name" required><br>
        <input type="text" name="username" placeholder="username" required><br>
        <input type="password" name="password" placeholder="password" required><br>
        <input type="password" name="repeatpassword" placeholder="repeat password" required><br>
        <input type="radio" name="gender" value="MALE" required>male<br>
        <input type="radio" name="gender" value="FEMALE" required>female<br>
        <input type="submit" value="signup">
    </form>
    <%
        Boolean wrongRepeat = (Boolean) request.getAttribute("wrongRepeat");
        Boolean duplicateUsername = (Boolean) request.getAttribute("duplicateUsername");
        if(wrongRepeat != null && wrongRepeat){ %>
            <p class="msg">repeat password carefully</p>
        <% } else if(duplicateUsername != null && duplicateUsername){ %>
                <p class="msg">this username already exists!!!</p>
        <% } %>
</body>
</html>
