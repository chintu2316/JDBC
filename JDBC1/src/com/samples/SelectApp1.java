package com.samples;

import java.awt.image.RescaleOp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectApp1 {

	public static void main(String[] args) throws Exception
	{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter department ID:");
		int no=sc.nextInt();
		Connection cn=null;
		Statement st=null;
		String q=null;
		try
		{
			Connection con=DBConnection.getConnection();
			st=con.createStatement();
			q="select * from dept where dept_id="+no;
			ResultSet rs=st.executeQuery(q);
			
			int count=0;
			while(rs.next())
			{
				System.out.println(rs.getInt("dept_id")+"-"+rs.getString("dept_name")+"-"+rs.getString("loc"));
			count=1;
			}
			if(count==0)
			{
				System.out.println("No records found on this department ID");
			}
			rs.close();
			con.close();
			st.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
