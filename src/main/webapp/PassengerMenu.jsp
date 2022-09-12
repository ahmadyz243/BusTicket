<%@ page import="java.util.List" %>
<%@ page import="domain.ComService" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="passenger-menu-style.css">
    <title>Costumer Menu</title>
</head>
<body>
<div id="header">
    <form action="http://localhost:8080/OnlineTicketWebApp_war_exploded/passengermenu" method="post">
        <label for="ot" id="ol">origin</label>
        <label for="dt" id="dl">destination</label>
        <label for="date" id="dtl">Date of departure</label><br>
        <input type="text" id="ot" name="origin" placeholder="origin city">
        <input type="text" id="dt" name="destination" placeholder="destination">
        <input type="date" id="date" name="date" placeholder="date of departure">
        <input type="submit" id="submit" value="find">
    </form>
</div>
<a href="http://localhost:8080/OnlineTicketWebApp_war_exploded/view-tickets">
    <div id="tickets">
        <h2>My Tickets</h2>
    </div>
    <div id="logout">
        <a href="http://localhost:8080/OnlineTicketWebApp_war_exploded/HomePage"><h2>Logout</h2></a>
    </div>
</a><br>
<% Boolean notFound = (Boolean) request.getAttribute("notFound");
    List<ComService> services = (List<ComService>) request.getAttribute("services");
    Integer userId = (Integer) request.getAttribute("userId");
    if (notFound != null && notFound) { %>
<p class="msg">No Service Found!</p>
<% } else if (services != null && userId != null) { %>
<table class="tables">
    <tr>
        <th class="borders">origin</th>
        <th class="borders">destination</th>
        <th class="borders">price</th>
        <th class="borders">empty seats</th>
        <th class="borders">company name</th>
        <th class="borders">date and time</th>
        <th class="borders"></th>
    </tr>
    <% for (ComService service : services) { %>
    <tr>
        <td class="borders"><%= service.getOriginCity() %>
        </td>
        <td class="borders"><%= service.getDestinationCity() %>
        </td>
        <td class="borders"><%= service.getPrice() %>
        </td>
        <td class="borders"><%= service.getEmptySeats() %>
        </td>
        <td class="borders"><%= service.getCompany().getName() %>
        </td>
        <td class="borders"><%= service.getDateAndTimeOfDeparture() %>
        </td>
        <td class="borders">
            <form action="http://localhost:8080/OnlineTicketWebApp_war_exploded/buyticket" method="get">
                <button name="buy" value="<%=service.getId() + "-" + userId%>">buy ticket</button>
            </form>
        </td>
    </tr>
    <% } %>
</table>
<% } %>
</body>
</html>
