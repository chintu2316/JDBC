package com.samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateInsert {

	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter dept_id");
		int id=sc.nextInt();
		System.out.println("enter department name");
		String name=sc.next();
		System.out.println("enter date of joining(dd-mm-yyyy");
		String sdoj=sc.next();
		
		//converting string to util date 
		SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
		java.util.Date udoj=sdf.parse(sdoj);
		
		//converting util to sql
		long ms=udoj.getTime();
		java.sql.Date sqldoj=new java.sql.Date(ms);
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","password");
		
		String q="insert into mydetails values(?,?,?)";
		
		PreparedStatement p=cn.prepareStatement(q);
		
		p.setInt(1, id);
		p.setString(2, name);
		p.setDate(3, sqldoj);
		
		int result=p.executeUpdate();
		
		if(result==0)
		{
			System.out.println("no records inserted");
		}
		else
			System.out.println("records inserted");
		
		cn.close();
		p.close();
		
		
		

	}

}
