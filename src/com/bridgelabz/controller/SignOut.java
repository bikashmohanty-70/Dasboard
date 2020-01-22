package com.bridgelabz.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignOut
 */
@WebServlet("/SignOut")
public class SignOut extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		session.removeAttribute("uname");
		session.invalidate();
		try 
		{
			response.sendRedirect("admin.jsp");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

}
