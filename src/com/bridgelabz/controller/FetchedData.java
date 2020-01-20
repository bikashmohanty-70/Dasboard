package com.bridgelabz.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	static Connection connectionObject = connectDatabase.connect();
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ResultSet resultSet = connectDatabase.readCompleteTable();
		
	}

}
