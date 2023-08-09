package com.samples;

import java.sql.Connection;
import java.sql.Statement;

public class BatchProcessing {

	public static void main(String[] args) throws Exception
	{
		Connection con=DBConnection.getConnection();
		Statement st=con.createStatement();
		String q1="Insert into dept values(4,'abs','pune')";
		String q2="Insert into dept values(2,'ab','pun')";
		String q3="Update dept set dept_name='andhra' where dept_id='4'";
		String q4="delete from dept where dept_id='2'";
		
		st.addBatch(q1);
		st.addBatch(q2);
		st.addBatch(q3);
		st.addBatch(q4);
		
		int[] result=st.executeBatch();
		
		int sum=0;
		
		for(int i:result)
		{
			sum+=i;
		}
		System.out.println("no.of record effected="+sum);
		
		st.close();
		con.close();

	}

}
