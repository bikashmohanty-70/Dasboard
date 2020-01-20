package com.bridgelabz.databaseactivexobject;
/**
 * @author Bikash Mohanty
 * @Since 27th Dec 2019
 * @version 1.0
 * 
 *  purpose: Database Connectivity Interface
 * 
 */
import java.sql.Connection;
import java.sql.ResultSet;

public interface IDatabaseConnectivity {

	Connection connect();

	boolean validateUser(String uname, String pass);

	int readData(String mail, String username, long number);

	ResultSet readAllData(String uname, String pswrd);

	boolean readEmail(String mail, String pwd);

}