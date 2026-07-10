package com.coforge.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PasswordStrengthServlet")
public class passwordStrengthServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String password = request.getParameter("pwd");

		if (password == null) {
			password = "";
		}

		if (password!=null && password.length() <= 3) {
			out.println("<font color='red'><b>Weak</b></font>");
		}
		else if (password!=null && password.length() <= 8) {
			out.println("<font color='orange'><b>Good</b></font>");
		}
		else {
			out.println("<font color='green'><b>Very Good</b></font>");
		}

		out.close();
	}
}