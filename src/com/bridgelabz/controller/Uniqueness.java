package com.bridgelabz.controller;
/**
 * @author Bikash Mohanty
 * @since 16 jan 2020
 * @version 1.0
 * 
 * purpose: TO check the uniqueness of user Input.
 */
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.databaseactivexobject.Databaseconnectivity;
import com.bridgelabz.databaseactivexobject.IConnectivity;
import com.bridgelabz.model.RegistrationModel;

/**
 * Servlet implementation class Uniqueness
 */
@WebServlet("/Uniqueness")
public class Uniqueness extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
      
	static RegistrationModel registrationModel = new RegistrationModel();
	static IConnectivity connectDatabase = new Databaseconnectivity();
	static Connection connectionObject = connectDatabase.connect();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String userEmail = request.getParameter("emailId");
		int checkmail = connectDatabase.readMail(userEmail);
		System.out.println("Email :   "+userEmail);
		
		if(checkmail == 1)
		{
			System.out.println("Returning 1 from Email...");
			String msg = "Email is already Registered.";
			response.setContentType("text/plain");
			response.getWriter().write(msg);
		}
		else
		{
			response.setContentType("text/plain");
			response.getWriter().write("");
		}

		String userName = request.getParameter("userName");
		int checkUsername = connectDatabase.readUsername(userName);
		
		if(checkUsername ==2) {
			System.out.println("Returning 1 from Username...");
			
			String msg = "UserName already Registered.";
			response.setContentType("text/plain");
			response.getWriter().write(msg);
		}
		else
		{
			response.setContentType("text/plain");
			response.getWriter().write("");
		}
		
		String phoneNumber = request.getParameter("number");
		int checkContact = connectDatabase.readContact(phoneNumber);	

		if(checkContact == 3)
		{
			System.out.println("Returning 1 from Contatc...");
			String msg = "Number is already Registered.";
			response.setContentType("text/html");
			response.getWriter().write(msg);
		}
		else
		{
			response.setContentType("text/plain");
			response.getWriter().write("");
		}

	}

}
