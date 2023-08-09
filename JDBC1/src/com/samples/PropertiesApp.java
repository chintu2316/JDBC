package com.samples;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class PropertiesApp {

	public static void main(String[] args) throws Exception
	{
		File f=new File("C:\\Users\\Reddy purushotham\\JDBC\\JDBC1\\src\\com\\samples\\Dbdetails.properties");
		FileInputStream fis=new FileInputStream(f);
		
		Properties p=new Properties();
		
		p.load(fis);
		
		String s1=p.getProperty("driver");
		String s2=p.getProperty("url");
		String s3=p.getProperty("username");
		String s4=p.getProperty("password");
		
		Class.forName(s1);
		Connection cn=DriverManager.getConnection(s2,s3,s4);
		Statement st=cn.createStatement();
		String q="select * from dept";
		ResultSet rs=st.executeQuery(q);
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
		rs.close();
		st.close();
		cn.close();
		
		

	}

}
