package com.samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeletePrepst {
	
	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter dept_id");
		int no=sc.nextInt();
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","password");
		String q="delete from dept where dept_id=(?)";
		
		PreparedStatement p=cn.prepareStatement(q);
		p.setInt(1, no);
		
		int result=p.executeUpdate();
		if(result==0)
			System.out.println("No records deleted");
		else
			System.out.println("record is Deleted");
		
		cn.close();
		p.close();
		
	}

}
