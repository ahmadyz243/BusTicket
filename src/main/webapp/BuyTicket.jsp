<%@ page import="enumiration.Gender" %><%--
  Created by IntelliJ IDEA.
  User: Rayan system
  Date: 8/28/2022
  Time: 9:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="passenger-menu-style.css">
    <title>Buy ticket</title>
</head>
<body>
<% String fname = (String) request.getAttribute("fname") , lname = (String) request.getAttribute("lname");
    Gender gender = (Gender) request.getAttribute("gender"); %>
<table class="tables">
    <tr>
        <td class="borders"><%= fname + " " + lname %></td>
        <td class="borders"><b>Firstname and Lastname</b></td>
    </tr>
    <tr>
        <td class="borders"><%= gender %></td>
        <td class="borders"><b>Gender</b></td>
    </tr>
    <tr>
        <td class="borders" colspan="2"><form action="http://localhost:8080/OnlineTicketWebApp_war_exploded/buyticket" method="post"><input type="submit" value="confirm shop"></form> </td>
    </tr>
</table>
</body>
</html>
