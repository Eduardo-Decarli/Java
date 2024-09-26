package db;

public class DbException extends RuntimeException{
    //Criação de uma exception personalizada para tratar os erros do DB
    public DbException(String msg){
        super(msg);
    }
}
