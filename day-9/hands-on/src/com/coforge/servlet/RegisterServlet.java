package com.coforge.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>User Details</h2>");
        out.println("Name : " + name + "<br>");
        out.println("Email : " + email);
        out.println("</body></html>");
    }
}