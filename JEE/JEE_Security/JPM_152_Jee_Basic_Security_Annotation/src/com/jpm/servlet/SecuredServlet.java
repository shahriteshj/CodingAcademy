package com.jpm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecuredServlet
 */
@WebServlet("/SecuredServlet")
@ServletSecurity(
        value = @HttpConstraint(rolesAllowed = {"tomcat"}),
        httpMethodConstraints = {
        		@HttpMethodConstraint(value = "GET", rolesAllowed = {"tomcat"}),
                @HttpMethodConstraint(value = "POST")
        })
public class SecuredServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append(
		"<h1>Secured servlet accessedthrough basic authentication:</h1><hr> ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
