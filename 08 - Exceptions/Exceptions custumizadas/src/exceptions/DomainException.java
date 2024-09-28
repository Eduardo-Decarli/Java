package exceptions;

//Aqui iremos criar uma classe para tratar exceptions personalizadas
//Precisamos declarar que a classe será filha de uma superclasse que contem exceptions
public class DomainException extends Exception{
    //Aqui criamos um construtor da nossa classe personalizada e declaramos que o conteudo passado irá para a superclasse Exception
    public DomainException(String msg){
        super(msg);
    }
}
