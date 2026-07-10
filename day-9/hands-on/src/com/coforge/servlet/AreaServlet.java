package com.coforge.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/AreaServlet")
public class AreaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");

        double r = Double.parseDouble(
                request.getAttribute("radius").toString());

        double area = 3.14 * r * r;

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Area of Circle</h2>");
        out.println("Radius = " + r + "<br>");
        out.println("Area = " + area);
        out.println("</body></html>");
    }
}