
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <b>
            <!-- Factorial of <%=request.getParameter("n")%> 
            is : <%=request.getParameter("fact")%> -->

            Factorial of <%=request.getAttribute("n")%> 
            is : <%=request.getAttribute("fact")%>


        </b>

    </body>

</html>