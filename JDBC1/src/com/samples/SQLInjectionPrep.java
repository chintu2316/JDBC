package com.samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SQLInjectionPrep {
	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter dept_id");
		int no=sc.nextInt();
		System.out.println("enter department name");
		String name=sc.next();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","password");
		String q="select count(*) from dept where dept_id=? and dept_name=?";
		
		PreparedStatement p=cn.prepareStatement(q);
		p.setInt(1, no);
		p.setString(2, name);
		
		ResultSet rs=p.executeQuery();
		int result=0;
		while(rs.next())
		{
			result=rs.getInt(1);
		}
		if(result==0)
			System.out.println("Invalid credentials");
		else
			System.out.println("Valid Credentials");
		
		cn.close();
		p.close();
	}
}
