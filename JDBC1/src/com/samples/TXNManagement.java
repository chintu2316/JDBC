package com.samples;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class TXNManagement {

	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter your account number :");
		int sno=sc.nextInt();
		
		System.out.println("enter destination account number:");
		int dno=sc.nextInt();
		
		System.out.println("enter the amount:");
		int amt=sc.nextInt();
		
		Connection con=DBConnection.getConnection();
		con.setAutoCommit(false);
		
		Statement st=con.createStatement();
		
		String q1="update hdfc set acbal=acbal-"+amt+" where acno="+sno;
		String q2="update kotak set acbal=acbal+"+amt+" where acno="+dno;
		
		st.addBatch(q1);
		st.addBatch(q2);
		
		int[] result=st.executeBatch();
		
		boolean flag=true;
		
		for(int i:result)
		{
			if(i==0)
			{
				flag=false;
				break;
			}
		}
		if(flag==true) {
			System.out.println("transaction done succesfully");
			con.commit();
			
		}
		else
		{
			System.out.println("Transaction failed");
		}
		
		

	}

}
