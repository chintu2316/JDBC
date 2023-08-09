package com.samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo {

	public static void main(String[] args) throws Exception {
		
		Connection cn=null;
		Statement st=null;
		ResultSet rs=null;
		String q=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","password");
			st=cn.createStatement();
			q="select * from dept";
			rs=st.executeQuery(q);
			while(rs.next())
			{
				System.out.println(rs.getInt("dept_id")+"-"+rs.getString("dept_name")+"-"+rs.getString("loc"));
			}
			rs.close();
			cn.close();
			st.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		

	}

}
