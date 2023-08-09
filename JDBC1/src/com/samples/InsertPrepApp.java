package com.samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertPrepApp {

	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter dept_id");
		int no=sc.nextInt();
		
		System.out.println("enter department name");
		String name=sc.next();
		
		System.out.println("enter department location");
		String loc=sc.next();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","password");
		String q="Insert into dept values(?,?,?)";
		
		PreparedStatement p=cn.prepareStatement(q);
		
		p.setInt(1, no);
		p.setString(2, name);
		p.setString(3, loc);
		
		int result=p.executeUpdate();
		if(result==0)
			System.out.println("No records inserted");
		else
			System.out.println("records inserted successfully");
		
		cn.close();
		p.close();

	}

}
