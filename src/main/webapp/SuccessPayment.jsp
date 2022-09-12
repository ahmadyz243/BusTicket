<%--
  Created by IntelliJ IDEA.
  User: Rayan system
  Date: 8/28/2022
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="passenger-menu-style.css">
    <title>Successful Payment</title>
</head>
<body>
<% String gen = (String) request.getAttribute("gen"), fname = (String) request.getAttribute("fname"),
        lname = (String) request.getAttribute("lname"); %>
<div id="buyticket">
    <p><%= gen + " " + fname + " " + lname + " " + "your payment was successful"%>
    </p>
</div>
<a id="back" href="http://localhost:8080/OnlineTicketWebApp_war_exploded/passengermenu">
    <button>back to menu</button>
</a>
</body>
</html>
