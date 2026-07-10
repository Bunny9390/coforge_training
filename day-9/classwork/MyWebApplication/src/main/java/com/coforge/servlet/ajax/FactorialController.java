package com.coforge.servlet.ajax;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FactorialServlet")
public class FactorialController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nParam = request.getParameter("n");
        int n = 0;
        try {
            n = Integer.parseInt(nParam);
        } catch (NumberFormatException e) {
            n = 0;
        }

        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/FactorialOutput.jsp");
        request.setAttribute("n", n);
        request.setAttribute("fact", fact);
        dispatcher.forward(request, response);
    }
}
