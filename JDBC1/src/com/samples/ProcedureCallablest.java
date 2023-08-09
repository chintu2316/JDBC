package com.samples;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class ProcedureCallablest {

    public static void main(String[] args) throws Exception {
        Connection con = DBConnection.getConnection();
        CallableStatement ct = con.prepareCall("{CALL first_pro(?,?,?)}");

        ct.registerOutParameter(3, Types.INTEGER);

        ct.setInt(1, 10);
        ct.setInt(2, 20);

        ct.execute();

        int result = ct.getInt(3);
        System.out.println("Sum of two numbers is: " + result);

        con.close();
        ct.close();
    }
}
