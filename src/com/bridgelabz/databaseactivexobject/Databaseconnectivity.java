package com.bridgelabz.databaseactivexobject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.model.RegistrationModel;

public class Databaseconnectivity implements IConnectivity
{
	protected static String mysqlURL = "jdbc:mysql://localhost:3306/bridgelabz?autoReconnect=true&useSSL=false";
	protected static String databaseName = "root";
	protected static String databasePassword = "Biki12@3";

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
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(mysqlURL, databaseName, databasePassword);
			statement = connection.createStatement();
		} 
		catch (SQLException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		return connection;

	}

	
	
	@Override
	public boolean insertIntoTable(RegistrationModel registrationModel)
	{
		String insertQueryForRegistrationTable = "INSERT INTO dashboardRegister (fname, lname, email, username, password, gender, city, state, contact, pin, dob) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try 
		{
			preparedStatementForRegistration = connection.prepareStatement(insertQueryForRegistrationTable);

			preparedStatementForRegistration.setString(1, registrationModel.getFname());
			preparedStatementForRegistration.setString(2, registrationModel.getLname());
			preparedStatementForRegistration.setString(3, registrationModel.getEmail());
			preparedStatementForRegistration.setString(4, registrationModel.getUsername());
			preparedStatementForRegistration.setString(5, registrationModel.getPassword());
			preparedStatementForRegistration.setString(6, registrationModel.getGender());
			preparedStatementForRegistration.setString(7, registrationModel.getCity());
			preparedStatementForRegistration.setString(8, registrationModel.getState());
			preparedStatementForRegistration.setLong(9, registrationModel.getContact());
			preparedStatementForRegistration.setInt(10, registrationModel.getPin());
			preparedStatementForRegistration.setString(11, registrationModel.getDateOfBirth());

			if (preparedStatementForRegistration.executeUpdate() == 1)
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;

	}

	
	@Override
	public boolean validateUser(String username, String password)
	{
		String query = "SELECT fname, lname, email, gender, city, state, contact, pin, dob FROM dashboardRegister WHERE username = ? and password =?";
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try 
		{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			result = preparedStatement.executeQuery();
			boolean status;
			status = result.next();
			return status;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(preparedStatement != null)
			{
				try 
				{
					preparedStatement.close();
				} 
				catch (SQLException e)
				{
					preparedStatement = null;
				}
			}
			
			if(result != null)
			{
				try 
				{
					result.close();
				} 
				catch (SQLException e)
				{
					result = null;
				}
			}
				
		}

		return false;
	}

	
	
	@Override
	public ResultSet readAllData(String uname, String pswrd)
	{
		String selectDataQuery = "SELECT fname, lname, email, gender, city, state, contact, pin, dob FROM dashboardRegister WHERE username = ? and password =?";
		try 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(selectDataQuery);
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
	public int readData(String mail, String username, long number)
	{
		ResultSet resultSetForReadData = null;
		String checkUnique = "SELECT email, username, contact FROM dashboardRegister WHERE username LIKE ? OR username LIKE ? or contact LIKE ?"; 
		//OR username LIKE ? or contact LIKE ? ";
		try 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(checkUnique);
			preparedStatement.setString(1, mail);
			preparedStatement.setString(2, username);
			preparedStatement.setLong(3, number);

			resultSetForReadData = preparedStatement.executeQuery();

			while(resultSetForReadData.next())
			{
				if(resultSetForReadData.getString(1).equals(mail))
					return 1;
				else if(resultSetForReadData.getString(2).equals(username))
					return 2;
				else if(resultSetForReadData.getString(3).equals(Long.toString(number)))
					return 3;
				else
					return 0;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if (resultSetForReadData != null) 
			{
				try 
				{
					resultSetForReadData.close();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}				
			}
		}
		return 0;
	}

	
	
	@Override
	public int readMail(String mail)
	{
		ResultSet resultSetForReadData = null;
		String checkUnique = "Select email, username, contact from dashboardregister where email = ?";
		try 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(checkUnique);
			preparedStatement.setString(1, mail);
			resultSetForReadData = preparedStatement.executeQuery();

			while(resultSetForReadData.next())
			{
				if(resultSetForReadData.getString(1).equals(mail))
					return 1;
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
	public int readUsername(String uname)
	{
		ResultSet resultSetForReadData = null;
		String checkUnique = "Select email, username, contact from dashboardregister where username = ?";
		try 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(checkUnique);
			preparedStatement.setString(1, uname);
			resultSetForReadData = preparedStatement.executeQuery();

			while(resultSetForReadData.next())
			{
				if(resultSetForReadData.getString(2).equals(uname))
					return 2;
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
	public int readContact(String contact)
	{
		ResultSet resultSetForReadData = null;
		String checkUnique = "Select email, username, contact from dashboardregister where contact = ?";
		try 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(checkUnique);
			preparedStatement.setString(1, contact);
			resultSetForReadData = preparedStatement.executeQuery();

			while(resultSetForReadData.next())
			{
				if(resultSetForReadData.getString(3).equals(contact))
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
	public ResultSet readCompleteTable() 
	{
		ResultSet resultSet = null;
		try 
		{
			resultSet = statement.executeQuery("SELECT * FROM user_register;");
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return resultSet;
	}



}
