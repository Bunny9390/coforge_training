package com.coforge.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null) username = "";
        if (password == null) password = "";

        if (username.equals("admin") && password.equals("123")) {
            //out.println("<font color='green'><b>Welcome Admin</b></font>");
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            Cookie cookie = new Cookie("username", username);
            response.addCookie(cookie);

            RequestDispatcher dispatcher = request.getRequestDispatcher("LoginSuccess.jsp");
            dispatcher.forward(request, response);

            // response.sendRedirect("LoginSuccess.jsp");
        } else {
            //out.println("<font color='red'><b>Invalid Admin</b></font>");
            response.sendRedirect("LoginFailure.jsp");
        }

        out.close();
    }
}