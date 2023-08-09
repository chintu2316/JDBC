package com.samples;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static Connection con=null;
	
	private DBConnection()
	{
		
	}
	public static Connection getConnection()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","password");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
		
		

	}

}
