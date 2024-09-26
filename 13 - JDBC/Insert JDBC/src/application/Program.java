package application;

import db.DB;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String [] args){

        /* INSERINDO DADOS NO DB */

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        PreparedStatement st = null;
        Connection conn = null;

        try{
            conn = DB.getConnection();
            st = conn.prepareStatement("INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            st.setString(1, "Carl Purple");
            st.setString(2, "carl@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
            st.setDouble(4, 3000.0);
            st.setInt(5, 4);

            int rowsAffected = st.executeUpdate();

            if(rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();

                while(rs.next()){
                    int id = rs.getInt(1);
                    System.out.println("Done! id = " + id);
                }
            }else{
                System.out.println("No rows affected!");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(ParseException e){
            System.out.println("Houve um erro na data: " + e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeConection();
        }
    }
}
