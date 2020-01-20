package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
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
 * Servlet implementation class FetchedData
 */
@WebServlet("/FetchedData")
public class FetchedData extends HttpServlet 
{
	static RegistrationModel registrationModel = new RegistrationModel();
	static IConnectivity connectDatabase = new Databaseconnectivity();
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ResultSet resultSet1 = connectDatabase.readCompleteTable("SELECT * FROM user_register");
		ResultSet resultSet2 = connectDatabase.readCompleteTable("SELECT * FROM user_register WHERE gender = 'm'");
		ResultSet resultSet3 = connectDatabase.readCompleteTable("SELECT * FROM user_register WHERE gender = 'f'");
		HttpSession session = request.getSession();
      
		if(session.getAttribute("uname") != null)
		{
			session.setAttribute("dataForTable", resultSet1);
			session.setAttribute("genderDataForTable", resultSet2);
			session.setAttribute("FemalesDataForTable", resultSet3);

			RequestDispatcher requestRd = request.getRequestDispatcher("dashboard.jsp");
			try 
			{
				requestRd.forward(request, response);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			PrintWriter out = response.getWriter();
			out.print("<script type='text/javascript'>alert('session expired...');</script>");

			try 
			{
				response.sendRedirect("dashboard.jsp");
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		
	}

}
