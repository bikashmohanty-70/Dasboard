package com.bridgelabz.model;
/**
 * 
 * @author Bikash Mohanty
 * @since 2nd January 2020
 * @version 1.0
 * 
 * Purpose: Model Class for User Registration
 *
 */
public class RegistrationModel 
{
	private String fname;
	private String lname;
	private String email;
	private String username;
	private String password;
	private String gender;
	private String city;
	private String state;
	private long contact;
	private int pin;
	private String dateOfBirth;
	
	/*First Name*/
	public String getFname() 
	{
		return fname;
	}
	public void setFname(String fname) 
	{
		this.fname = fname;
	}
	
	/*Laast Name*/
	public String getLname() 
	{
		return lname;
	}
	public void setLname(String lname) 
	{
		this.lname = lname;
	}
	
	/*Email*/
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	/*Username*/
	public String getUsername() 
	{
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	/*Password*/
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	/*Gender*/
	public String getGender() 
	{
		return gender;
	}
	public void setGender(String gender) 
	{
		this.gender = gender;
	}
	
	/*City*/
	public String getCity() 
	{
		return city;
	}
	public void setCity(String city) 
	{
		this.city = city;
	}
	
	/*State*/
	public String getState() 
	{
		return state;
	}
	public void setState(String state) 
	{
		this.state = state;
	}
	
	/*COntact*/
	public long getContact() 
	{
		return contact;
	}
	public void setContact(long contact) 
	{
		this.contact = contact;
	}
	
	/*Pincode*/
	public int getPin() 
	{
		return pin;
	}
	public void setPin(int pin) 
	{
		this.pin = pin;
	}
	
	/*D-O-B*/
	public String getDateOfBirth() 
	{
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) 
	{
		this.dateOfBirth = dateOfBirth;
	}
	
	
}
