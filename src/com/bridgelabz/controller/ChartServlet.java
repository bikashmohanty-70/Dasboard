package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.databaseactivexobject.Databaseconnectivity;
import com.bridgelabz.databaseactivexobject.IConnectivity;
import com.bridgelabz.model.RegistrationModel;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class ChartServlet
 */
@WebServlet("/ChartServlet")
public class ChartServlet extends HttpServlet 
{
	
	
	static RegistrationModel registrationModel = new RegistrationModel();
	static IConnectivity connectDatabase = new Databaseconnectivity();
	
	static Gson gson = new Gson();
	JsonObject jsonData = null;
	
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		
		ResultSet resultSetForChart = connectDatabase.readCompleteTable("SELECT state, count(*) as totalUsers FROM user_register GROUP BY state; ");
		JsonArray jsonArrayObj = new JsonArray();
		try 
		{
			while(resultSetForChart.next())
			{
				jsonData = new JsonObject();
				jsonData.addProperty("State", resultSetForChart.getString(1));
				jsonData.addProperty("totalUsers", resultSetForChart.getString(2));
				jsonArrayObj.add(jsonData);
			}				
			
			System.out.println(jsonData.toString());
			System.out.println(jsonArrayObj.toString());
			response.setContentType("application/json");
			
	        try 
	        {
	            out.println(jsonArrayObj);
	        } 
	        finally 
	        {
	            out.close();
	        }
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
	}

}
