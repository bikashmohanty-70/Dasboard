package com.bridgelabz.databaseactivexobject;

import java.sql.Connection;
import java.sql.ResultSet;

import com.bridgelabz.model.RegistrationModel;

public interface IConnectivity {

	Connection connect();

	boolean insertIntoTable(RegistrationModel registrationModel);

	boolean validateUser(String username, String password);

	ResultSet readAllData(String uname, String pswrd);

	int readData(String mail, String username, long number);

	int readMail(String mail);

	int readUsername(String uname);

	int readContact(String contact);

	ResultSet readCompleteTable(String sql);

}