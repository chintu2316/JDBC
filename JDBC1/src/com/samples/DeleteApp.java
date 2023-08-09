package com.samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteApp {

	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter dept_id:");
		int dept_id=sc.nextInt();
		
		
		
		Connection cn=null;
		Statement st=null;
		String q=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","password");
			st=cn.createStatement();
			q="delete from dept  where dept_id="+dept_id;
			
			int result=st.executeUpdate(q);
			
			if(result==0)
			{
				System.out.println("no records deleted");
			}
			else
			{
				System.out.println(result+"Record Deleted");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
