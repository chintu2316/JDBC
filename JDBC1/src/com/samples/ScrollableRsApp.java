package com.samples;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollableRsApp {
	public static void main(String[] args) throws Exception {
        Connection con = DBConnection.getConnection();
        
        Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
        								 ResultSet.CONCUR_READ_ONLY);
        String q="select * from dept";
        
        ResultSet rs=st.executeQuery(q);
        
        while(rs.next())
        {
        	System.out.println(rs.getRow()+" "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
        System.out.println("+======================================+");
        rs.afterLast();
        while(rs.previous())
        {
        	System.out.println(rs.getRow()+" "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
        
        System.out.println("+======================================+");
        
        rs.first();
        System.out.println(rs.isFirst());
        
        
        System.out.println("+======================================+");
        
        rs.last();
        System.out.println(rs.isLast());
        System.out.println(rs.getRow()+" "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
        
        System.out.println("+======================================+");
        rs.relative(-2);
        System.out.println(rs.getRow()+" "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
        System.out.println("+======================================+");
        rs.absolute(3);
        System.out.println(rs.getRow()+" "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
        System.out.println("+======================================+");
        rs.beforeFirst();
        while(rs.next())
        {
        	System.out.println(rs.getRow()+" "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
        
        
		rs.close();
		st.close();
		con.close();
	}
}
