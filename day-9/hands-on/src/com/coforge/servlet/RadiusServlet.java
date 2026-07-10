package com.coforge.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/RadiusServlet")
public class RadiusServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String radius = request.getParameter("radius");

        request.setAttribute("radius", radius);

        RequestDispatcher rd =
                request.getRequestDispatcher("AreaServlet");

        rd.forward(request, response);
    }
}