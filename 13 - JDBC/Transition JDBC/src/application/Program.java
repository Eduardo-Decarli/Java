package application;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String [] args) {
        Connection conn = null;
        Statement st = null;

        try{
            conn = DB.getConnection();

            conn.setAutoCommit(false);

            st = conn.createStatement();

            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

            int x = 1;
            if(x < 2){
                throw new SQLException("Fake error");
            }

            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");



            System.out.println("rows 1: " + rows1);
            System.out.println("rows 2: " + rows2);
        }
        catch(SQLException e){
            try {
                conn.rollback();
                throw new DbException("Transaction rolled back! Cause by "+ e.getMessage());
            }
            catch(SQLException x){
                throw new DbException("Transaction rolled back! Cause by "+ x.getMessage());
            }
        }
        finally {
            DB.closeStatement(st);
            DB.closeConection();
        }
    }
}
