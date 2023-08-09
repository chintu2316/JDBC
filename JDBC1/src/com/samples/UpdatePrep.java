package com.samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdatePrep {

	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter dept_id");
		int no=sc.nextInt();
		
		System.out.println("enter department name");
		String name=sc.next();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","password");
		String q="update dept set loc=(?) where dept_id=(?)";
		
		PreparedStatement p=cn.prepareStatement(q);
		p.setString(1, name);
		p.setInt(2, no);
		
		int result=p.executeUpdate();
		if(result==0)
			System.out.println("No records Updated");
		else
			System.out.println("record is Updated");
		
		cn.close();
		p.close();
		
	}

}
