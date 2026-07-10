<%@ page language="java" %>

<html>
<body>

<%!

int a = 10;
int b = 20;

int add()
{
    return a + b;
}

%>

<%

out.println("<h2>Using Scriptlet</h2>");

%>

<h3>Using Expression</h3>

Sum = <%= add() %>

</body>
</html>