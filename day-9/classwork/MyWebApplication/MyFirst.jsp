<% page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- <%-- JSP declaration code--%> -->
        <%!
            String name = "John Doe";
            int a =10,b=20;
            %>
        <!-- <%-- JSP scriptlet code--%> -->
         <%!
            System.out.println("<br>Welcome"+name);
            if (a>b)
            {
                System.out.println("<br>A is greater than B");
            }
            else
            {
                System.out.println("<br>B is greater than A");
            }
            int sum = a+b;
            %>
            <br>
            <!-- <%-- JSP expression code--%> -->
             sum = <%=sum%>

            
        <h1>Welcome to JSP</h1>
        <p>This is my first JSP page.</p>
    </body>

</html>