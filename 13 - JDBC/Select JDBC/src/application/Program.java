package application;

import db.DB;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String [] args){


        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        /* BUSCANDO CONTEUDO NO DB */

        try{

            // Faz a conexão com o DB
            conn = DB.getConnection();

            // Prepara a consulta no banco armazenado em Conn
            st = conn.createStatement();

            //Faz a requisição ao comando SQL selecionado
            rs = st.executeQuery("select * from department");

            //Enquanto houver uma proxima linha da tabela department
            while (rs.next()){
                //Irá imprimir o conteudo inteiro na coluna id e a string na coluna name
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }

        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConection();
        }

        /* INSERINDO DADOS NO DB */

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        PreparedStatement stt = null;
        try{
            conn = DB.getConnection();
            stt = conn.prepareStatement("INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES (?,?,?,?,?)");

            stt.setString(1, "Carl Purple");
            stt.setString(2, "carl@gmail.com");
            stt.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
            stt.setDouble(4, 3000.0);
            stt.setInt(5, 4);

            int rowsAffected = stt.executeUpdate();
            System.out.println("Done! Rows affected: " + rowsAffected);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(ParseException e){
            System.out.println("Houve um erro na data: " + e.getMessage());
        }
        finally {
            DB.closeStatement(stt);
            DB.closeConection();
        }
    }
}
