<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body{
            background-color: dodgerblue;
        }
        #user-login{
            display: inline-block;
            background-color: antiquewhite;
            width: 280px;
            height: 305px;
            margin-top: 11%;
            margin-left: 20%;
            text-align: center;
            padding-top: 10px;
            font-family: 'Lucida Sans Regular', 'Lucida Grande', Arial, Helvetica, sans-serif, 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
        }
        #company-login{
            display: inline-block;
            background-color: antiquewhite;
            width: 280px;
            height: 305px;
            margin-top: 11%;
            margin-left: 20%;
            text-align: center;
            padding-top: 10px;
            font-family: 'Lucida Sans Regular', 'Lucida Grande', Arial, Helvetica, sans-serif, 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
        }
        #tuu{
            margin-bottom: 10px;
            width: 250px;
            height: 40px;
            text-align: center;
        }
        #ppu{
            margin-bottom: 10px;
            width: 250px;
            height: 40px;
            text-align: center;
        }
        #bu{
            margin-bottom: 10px;
            width: 250px;
            height: 40px;
            color: white;
            background-color: blue;
            border: none;
            text-align: center;
        }
        #tuc{
            margin-bottom: 10px;
            width: 250px;
            height: 40px;
            text-align: center;
        }
        #ppc{
            margin-bottom: 10px;
            width: 250px;
            height: 40px;
            text-align: center;
        }
        #bc{
            margin-bottom: 10px;
            width: 250px;
            height: 40px;
            color: white;
            background-color: blue;
            border: none;
            text-align: center;
        }
        .sucMsg{
            color: darkgreen;
        }
        .msg{
            color: red;
        }
    </style>
    <title>Login or Signup</title>
</head>
<body>
<div id="user-login">
    <caption>User login</caption>
    <br><br>
    <form action="http://localhost:8080/OnlineTicketWebApp_war_exploded/HomePage" method="post">
        <input type="text" id="tuu" name="u-username" placeholder="username" required><br>
        <input type="password" id="ppu" name="password" placeholder="password" required><br>
        <input type="submit" id="bu" value="login"><br>
        <% Boolean uLoginFailed = (Boolean) request.getAttribute("uLoginFail");
            Boolean signedU = (Boolean) request.getAttribute("signedU"); %>
        <% if (uLoginFailed != null && uLoginFailed) { %>
        <p class="msg">wrong username or password</p>
        <% } %>
        <% if (signedU != null && signedU) { %>
        <p class="sucMsg">Signup was successful</p>
        <% } %>
    </form>
    <a href="http://localhost:8080/OnlineTicketWebApp_war_exploded/passengersignup"><small>don't have an account?
        signup</small></a>
</div>
<div id="company-login">
    <caption>Company login</caption>
    <br><br>
    <form action="http://localhost:8080/OnlineTicketWebApp_war_exploded/HomePage" method="post">
        <input type="text" id="tuc" name="c-username" placeholder="username" required><br>
        <input type="password" id="ppc" name="password" placeholder="password" required><br>
        <input type="submit" id="bc" value="login"><br>
        <% Boolean cLoginFailed = (Boolean) request.getAttribute("cLoginFail");
            Boolean signedC = (Boolean) request.getAttribute("signedC"); %>
        <% if (cLoginFailed != null && cLoginFailed) { %>
        <p class="msg">wrong username or password</p>
        <% } %>
        <% if (signedC != null && signedC) { %>
        <p class="sucMsg">Signup was successful</p>
        <% } %>
    </form>
    <a href="http://localhost:8080/OnlineTicketWebApp_war_exploded/companysignup"><small>don't have an account?
        signup</small></a>
</div>
<br>

</body>
</html>
