package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;


import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.databaseactivexobject.Databaseconnectivity;
import com.bridgelabz.databaseactivexobject.IConnectivity;
import com.bridgelabz.model.RegistrationModel;


/**
 * Servlet implementation class Dashboard_Admin
 */
@WebServlet("/Dashboard_Admin")
public class Dashboard_Admin extends HttpServlet 
{
	static RegistrationModel registrationModel = new RegistrationModel();
	static IConnectivity connectDatabase = new Databaseconnectivity();
	static Connection connectionObject = connectDatabase.connect();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter printWriter = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("pass");
		
		try 
		{
			boolean status = connectDatabase.validateUser(username, password);
			if(status)
			{
				/**
				 * Creating Session
				 */
				
				HttpSession session = request.getSession();
				session.setAttribute("uname", username);
				
				RequestDispatcher requestDisp = request.getRequestDispatcher("dashboard.jsp");
				requestDisp.forward(request, response);
			}
			else
			{
				printWriter.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				printWriter.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				printWriter.println("<script>");
				printWriter.println("$(document).ready(function(){");
				printWriter.println("swal('Ooopsss..!', 'You have Enterd Wrong Credentials.', 'error');");
				printWriter.println("});");
				printWriter.println("</script>");
				
				RequestDispatcher requestDisp = request.getRequestDispatcher("admin.jsp");
				requestDisp.include(request, response);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

}
