package com.samples;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;
import java.text.SimpleDateFormat;

public class DateRetrieve {

	public static void main(String[] args) throws Exception{
		
		Connection con=DBConnection.getConnection();
		Statement st=con.createStatement();
		String q="select * from mydetails";
		
		ResultSet rs=st.executeQuery(q);
		while(rs.next())
		{
			int id=rs.getInt(1);
			String name=rs.getString(2);
			Date sqldoj=rs.getDate(3);
			
			//converting sql to util
			java.util.Date udoj=(java.util.Date)sqldoj;
			
			//converting util to string
			SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
			String sdoj=sdf.format(udoj);
			
			System.out.println(id+" "+name+" "+sdoj);
		}
		rs.close();
		st.close();
		con.close();

	}

}
