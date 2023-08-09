package com.samples;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DDMD {

	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","password");
		
		DatabaseMetaData db=cn.getMetaData();
		System.out.println(db.getDatabaseProductName());
		System.out.println(db.getDatabaseProductVersion());
		System.out.println(db.getDriverName());
		System.out.println(db.getDriverVersion());
		System.out.println(db.getUserName());

	}

}
