package com.bridgelabz.controller;
/**
 * @author Bikash Mohanty
 * @since 2nd January 2020
 * @version 1.0
 * 
 * purpose: User Registration Servlet
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.databaseactivexobject.Databaseconnectivity;
import com.bridgelabz.databaseactivexobject.IConnectivity;
import com.bridgelabz.model.RegistrationModel;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet 
{
	static RegistrationModel registrationModel = new RegistrationModel();
	static IConnectivity connectDatabase = new Databaseconnectivity();
	static Connection connectionObject = connectDatabase.connect();
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher dispatcherObject = null;	//Creating RequestDispatcher Object
		PrintWriter printWriter = response.getWriter();
		/**
		 *	Fetching Data from Register Page and setting values using Model Class Object. 
		 */

		String firstname = request.getParameter("firstname");
		registrationModel.setFname(firstname);

		String lastname = request.getParameter("lastname");
		registrationModel.setLname(lastname);

		String mail = request.getParameter("mail");
		registrationModel.setEmail(mail);


		String username = request.getParameter("username");
		registrationModel.setUsername(username);
		
		/*Encrypting Password using AES algorithm*/

		String password = request.getParameter("password");
		registrationModel.setPassword(password);
		
		String customRadioInline1 = request.getParameter("customRadioInline1");
		registrationModel.setGender(customRadioInline1);

		String dob = request.getParameter("dob");
		registrationModel.setDateOfBirth(dob);

		String contact = request.getParameter("contact");
		System.out.println( request.getParameter("contact"));
		try 
		{	
			registrationModel.setContact(Long.parseLong(contact));
		} 
		catch (NumberFormatException e) 
		{
			e.printStackTrace();
		}


		String city = request.getParameter("city");
		registrationModel.setCity(city);

		String state = request.getParameter("state");
		registrationModel.setState(state);

		String pincode = request.getParameter("pincode");
		try 
		{
			registrationModel.setPin(Integer.parseInt(pincode));
		} 
		catch (NumberFormatException e) 
		{
			e.printStackTrace();
		}
		
		
//		boolean flag = (boolean)request.getAttribute("flag_from_uniqueness");
		

		if(connectDatabase.insertIntoTable(registrationModel))
		{
			printWriter.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			printWriter.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			printWriter.println("<script>");
			printWriter.println("$(document).ready(function(){");
			printWriter.println("swal('Thank You!', 'You have been successfully registered.', 'success');");
			printWriter.println("});");
			printWriter.println("</script>");

//			ServletContext context=getServletContext();  
//			context.setAttribute("secretKey", secretKey); 
			
			dispatcherObject = request.getRequestDispatcher("admin.jsp");
			try 
			{
				dispatcherObject.include(request, response);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Inside else");
			printWriter.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			printWriter.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			printWriter.println("<script>");
			printWriter.println("$(document).ready(function(){");
			printWriter.println("swal('Thank You!', 'You've Entered Wrong Credentials after being Warned.', 'error');");
			printWriter.println("});");
			printWriter.println("</script>");
//			request.setAttribute("resgistrationStatus", true);
			dispatcherObject = request.getRequestDispatcher("register.jsp");
			try 
			{
				dispatcherObject.include(request, response);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}

	}


}
