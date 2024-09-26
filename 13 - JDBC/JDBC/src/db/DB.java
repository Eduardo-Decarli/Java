package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    //Classe responsavel por ler o arquivo de conexão ao DB e conseguir conectar com sucesso

    private static Connection conn = null;

    public static Connection getConnection(){
        if(conn == null){
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            }
            catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    public static void closeConection(){
        if(conn != null){
            try {
                conn.close();
            }
            catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    private static Properties loadProperties(){
        // A classe FileInputStream permite que você abra um arquivo e leia seu conteúdo em forma de bytes, sendo ideal para trabalhar com arquivos binários,
        try(FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        }
        catch(IOException e){
            throw new DbException(e.getMessage());
        }
    }
}
