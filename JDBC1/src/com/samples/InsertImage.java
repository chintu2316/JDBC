package com.samples;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertImage {

	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter dept_id");
		int id=sc.nextInt();
		System.out.println("enter department name");
		String name=sc.next();
		
		File f=new File("C:\\Users\\Reddy purushotham\\Downloads\\Telegram Desktop\\wp.jpg");
		FileInputStream fis=new FileInputStream(f);
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","password");
		
		String q="insert into mydetails values(?,?,?)";
		
		PreparedStatement p=cn.prepareStatement(q);
		
		p.setInt(1, id);
		p.setString(2, name);
		p.setBinaryStream(3, fis, (int)f.length());
		
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
