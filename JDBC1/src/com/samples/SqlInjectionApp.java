package com.samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SqlInjectionApp {

	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
//		System.out.println("enter dept_id");
//		int no=sc.nextInt();
		
		System.out.println("enter department name");
		String name=sc.next();
		
		System.out.println("enter department location");
		String loc=sc.next();
		
		//convertion
		name="'"+name+"'";
		loc="'"+loc+"'";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","password");
		Statement st=cn.createStatement();
		
		String q="select count(*) from dept where dept_name="+name+" and loc="+loc;
		
		ResultSet rs=st.executeQuery(q);
		int result=0;
		while(rs.next())
		{
			result=rs.getInt(1);
		}
		if(result==0)
			System.out.println("Invalid Input");
		else
			System.out.println("valid Inputs");
		
		rs.close();
		cn.close();
		st.close();
	}

}
