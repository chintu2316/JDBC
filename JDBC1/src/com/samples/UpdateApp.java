package com.samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateApp {

	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter dept_id:");
		int dept_id=sc.nextInt();
		System.out.println("enter dept name:");
		String dept_name=sc.next();
		
		dept_name="'"+dept_name+"'";
		
		Connection cn=null;
		Statement st=null;
		String q=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","password");
			st=cn.createStatement();
			q="Update dept set dept_name="+dept_name+" where dept_id="+dept_id;
			
			int result=st.executeUpdate(q);
			
			if(result==0)
			{
				System.out.println("no records updated");
			}
			else
			{
				System.out.println(result+"Record Updated");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
