package com.bridgelabz.databaseactivexobject;
/**
 * @author Bikash Mohanty
 * @Since 27th Dec 2019
 * @version 1.0
 * 
 *  purpose: Database Connectivity Class
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseActivexObjectClass implements IDatabaseConnectivity 
{
	protected static String mysqlURL = "jdbc:mysql://localhost:3306/bridgelabz?autoReconnect=true&useSSL=false";
	protected static String databaseName = "root";
	protected static String databasePassword = "Biki12@3";
	static String sqlQuery = "SELECT r.fname, r.lname, r.mail, r.city, r.contact FROM registration AS r JOIN login as l ON r.sid = l.sid WHERE l.username = ? and l.PASSWORD = ?";
	static String insertQueryForRegistrationTable = "INSERT INTO registration (fname, lname, mail, city, contact) VALUES (?, ?, ?, ?, ?)";
	static String insertQueryForLoginTable = "INSERT INTO login (username, PASSWORD) VALUES (?, ?)";

	Connection connection = null;
	PreparedStatement preparedStatementForRegistration = null;
	PreparedStatement preparedStatementForLogin = null;
	ResultSet resultSetForRegistration = null;
	ResultSet resultSetForLogin = null;
	Statement statement = null;

	@Override
	public Connection connect()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(mysqlURL, databaseName, databasePassword);
			statement = connection.createStatement();
		} 
		catch (SQLException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		//		finally 
		//		{
		//			try 
		//			{
		//				if(connection != null)
		//					connection.close();
		//				if(preparedStatement != null)
		//					preparedStatement.close();
		//				if(resultSet != null)
		//					resultSet.close();
		//			}
		//			catch (SQLException e) 
		//			{
		//				e.printStackTrace();
		//			}	
		//			
		//		}
		return connection;

	}

	public boolean insert(String fname, String lname, String mail, String username, String password, String city, long number)
	{
		try 
		{
			preparedStatementForRegistration = connection.prepareStatement(insertQueryForRegistrationTable);
			preparedStatementForRegistration.setString(1, fname);
			preparedStatementForRegistration.setString(2, lname);
			preparedStatementForRegistration.setString(3, mail);
			preparedStatementForRegistration.setString(4, city);
			preparedStatementForRegistration.setLong(5, number);

			int registrationCheck = preparedStatementForRegistration.executeUpdate();

			preparedStatementForLogin = connection.prepareStatement(insertQueryForLoginTable);
			preparedStatementForLogin.setString(1, username);
			preparedStatementForLogin.setString(2, password);

			int loginCheck = preparedStatementForLogin.executeUpdate();

			if(registrationCheck == 1 && loginCheck == 1)
			{
				return true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean validateUser(String uname, String pass)
	{
		ResultSet result = null;
		try 
		{
			result = statement.executeQuery("SELECT * FROM login");
			System.out.println(result);
			while(result.next())
			{
				if(result.getString(1).equals(uname) && result.getString(2).equals(pass))
					return true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}


	//Reading Data from Tables

	@Override
	public int readData(String mail, String username, long number)
	{
		ResultSet resultSetForReadData = null;

		try 
		{
			resultSetForReadData = statement.executeQuery("SELECT r.mail, r.contact, l.username FROM registration AS r JOIN login as l ON r.sid = l.sid ");
			while(resultSetForReadData.next())
			{
				if(resultSetForReadData.getString(1).equals(mail))
					return 1;
				else if(resultSetForReadData.getString(2).equals(Long.toString(number)))
					return 2;
				else if(resultSetForReadData.getString(3).equals(username))
					return 3;
				else
					return 0;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public ResultSet readAllData(String uname, String pswrd)
	{
		try 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, uname);
			preparedStatement.setString(2, pswrd);
			ResultSet result = preparedStatement.executeQuery();
			
			return result;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public boolean readEmail(String mail, String pwd)
	{
		PreparedStatement preparedStatement = null;
//		String sql = "UPDATE login l INNER JOIN registration r ON l.sid=r.sid SET l.PASSWORD=? WHERE r.mail=?;";
		String sql = "UPDATE login l INNER JOIN registration r ON l.sid=r.sid SET l.PASSWORD=? WHERE r.mail=?";
		try 
		{
			System.out.println(connection);
			preparedStatement = connection.prepareStatement(sql);
		
			preparedStatement.setString(1, pwd);
			preparedStatement.setString(2, mail);
			int result = preparedStatement.executeUpdate();
			if(result > 0)
				return true;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				if(preparedStatement != null)
					preparedStatement.close();
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return false;
	}
}
