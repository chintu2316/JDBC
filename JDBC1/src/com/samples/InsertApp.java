package com.samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertApp {

	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter dept_id:");
		int dept_id=sc.nextInt();
		System.out.println("enter dept name:");
		String dept_name=sc.next();
		System.out.println("enter dept location:");
		String dept_loc=sc.next();
		
		//conerting
		dept_name="'"+dept_name+"'";
		dept_loc="'"+dept_loc+"'";
		
		Connection cn=null;
		Statement st=null;
		String q=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","password");
			st=cn.createStatement();
			q="INSERT INTO dept (dept_id, dept_name, loc) " +" values("+dept_id+","+dept_name+","+dept_loc+")";
			
			int result=st.executeUpdate(q);
			
			if(result==0)
			{
				System.out.println("no records inserted");
			}
			else
			{
				System.out.println(result+"Record Inserted");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
