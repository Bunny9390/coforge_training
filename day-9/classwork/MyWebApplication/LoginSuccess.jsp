<% page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <!-- <p><font color="green"><b>Welcome <%= session.getAttribute("username") %></b></font></p> -->
        <%
        Cookie[] cookies = request.getCookies();

        System.out.println("<font color='green'><b>Welcome"+cookies[1].getValue() + "</b></font>");
        %>
    </body>

</html>