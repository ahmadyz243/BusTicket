<%@ page import="java.util.List" %>
<%@ page import="domain.Ticket" %><%--
  Created by IntelliJ IDEA.
  User: Rayan system
  Date: 8/28/2022
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="passenger-menu-style.css">
    <title>View Tickets</title>
</head>
<body>
<% List<Ticket> tickets = (List<Ticket>) request.getAttribute("tickets");
    if (tickets == null || tickets.size() == 0) { %>
<p class="msg">You have no tickets yet</p>
<% } else { %>
<table class="tables">
    <tr>
        <th colspan="3" class="borders">your ticket list</th>
    </tr>
    <tr>
        <th class="borders">Date</th>
        <th class="borders">Ticket Id</th>
        <th class="borders">Select</th>
    </tr>
    <%
        for (Ticket ticket :
                tickets) { %>
    <tr>
        <td class="borders"><%= ticket.getDate() %>
        </td>
        <td class="borders"><%= ticket.getId() %>
        </td>
        <td class="borders">
            <form action="" method="post">
                <button name="ticket-id" value="<%=ticket.getId()%>"><small>view this ticket</small></button>
            </form>
        </td>
    </tr>
    <% } %>
</table>
<% } %>
</body>
</html>
