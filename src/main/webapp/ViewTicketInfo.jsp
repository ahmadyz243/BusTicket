<%@ page import="domain.Ticket" %><%--
  Created by IntelliJ IDEA.
  User: Rayan system
  Date: 8/28/2022
  Time: 1:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="passenger-menu-style.css">
    <title>View Ticket Info</title>
</head>
<body>
    <% Ticket ticket = (Ticket) request.getAttribute("ticket"); %>
    <table class="tables">
        <tr>
            <th colspan="2" class="borders">Bus Ticket</th>
        </tr>
        <tr>
            <th class="borders">ticket id</th>
            <td class="borders"><%=ticket.getId()%></td>
        </tr>
        <tr>
            <th class="borders">name</th>
            <td class="borders"><%=ticket.getPassenger().getFirstName() + " "  + ticket.getPassenger().getLastName()%></td>
        </tr>
        <tr>
            <th class="borders">gender</th>
            <td class="borders"><%=ticket.getPassenger().getGender()%></td>
        </tr>
        <tr>
            <th class="borders">origin city</th>
            <td class="borders"><%=ticket.getOrigin()%></td>
        </tr>
        <tr>
            <th class="borders">destination city</th>
            <td class="borders"><%=ticket.getDestination()%></td>
        </tr>
        <tr>
            <th class="borders">date and time</th>
            <td class="borders"><%=ticket.getDate()%></td>
        </tr>
        <tr>
            <th class="borders">service id</th>
            <td class="borders"><%=ticket.getService().getId()%></td>
        </tr>
        <tr>
            <th class="borders" colspan="2"><form action="http://localhost:8080/OnlineTicketWebApp_war_exploded/delete-ticket" method="post">
                <button id="del" name="del-ticket-id" value="<%=ticket.getId()%>">delete this ticket</button>
            </form></th>
        </tr>
    </table>
</body>
</html>
