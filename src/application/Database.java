package application;

import java.sql.*;

public class Database {
	
	 Connection con=null;
	 
	 public static Connection dbconnect() {
		 
	 try {		 
		 String url = "jdbc:sqlite:C:/Users/gytim/eclipse-workspace/EmployeeRegistry/bin/db/employeeManagement.db";
		 Connection connection = DriverManager.getConnection(url);

		 return connection;
	   
	 }
	 catch(Exception ex) {
		 System.out.println(ex.toString());
	  return null;
	 }
	 
	   
	 }

	}