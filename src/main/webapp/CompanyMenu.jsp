<%--
  Created by IntelliJ IDEA.
  User: Rayan system
  Date: 8/27/2022
  Time: 6:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Company Menu</title>
</head>
<body>
    <header>
        <h2>add service</h2><br>
    </header>
    <nav>
        <a href="http://localhost:8080/OnlineTicketWebApp_war_exploded/HomePage">
            <button type="button">log out</button>
        </a>
    </nav>
    <article>
        <form action="http://localhost:8080/OnlineTicketWebApp_war_exploded/companymenu" method="post" name="add-service-form">
            <input type="text" name="origincity" placeholder="origin city" required><br>
            <input type="text" name="destionationcity" placeholder="destination city" required><br>
            <input type="number" name="emptyseats" placeholder="number of empty seats" required><br>
            <input type="number" name="price" placeholder="price" required><br>
            <input type="datetime-local" name="datetime" placeholder="date & time of Departure" required><br>
            <input type="submit" value="add"><br>
        </form>
        <%
            Boolean duplicateCities = (Boolean) request.getAttribute("duplicateCities");
            Boolean invalidDate = (Boolean) request.getAttribute("invalidDate");
            Boolean allDone = (Boolean) request.getAttribute("allDone");
            if(duplicateCities != null && duplicateCities){ %>
        <p class="msg">origin and destination can not be the same!!!</p>
        <% }else if (invalidDate != null && invalidDate){ %>
        <p class="msg">wrong time entry!!!</p>
        <% }else if(allDone != null && allDone){ %>
        <p class="msg">Service Added Successfully</p>
        <% } %>
    </article>
</body>
</html>
