package com.samples;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
// Sample.class for output
public class Imageretrieve {
	 static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","password");
		Statement st=cn.createStatement();
		String q="select * from mydetails";
		ResultSet rs=st.executeQuery(q);
		while(rs.next())
		{
			InputStream is=rs.getBinaryStream(3);
			int bytereads=0;
			byte[] buff=new byte[300];
			FileOutputStream fos=new FileOutputStream("C:\\Users\\Reddy purushotham\\Downloads\\Telegram Desktop\\wp1.jpg");
			
				while((bytereads=is.read(buff))!=-1)
				{
					fos.write(buff, 0, bytereads);
				}
				fos.close();
				
		}
		System.out.println("please check the location");
		rs.close();
		st.close();
		cn.close();
	 }
}