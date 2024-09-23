package model.services;

//Para criar uma interface, fazemos dessa forma, declarando que a classe é uma interface
public interface TaxService {

    //Aqui declaramos que todas as classes que implementarem a interface, farão o contrato de implementar essa função
    double tax(double amount);
}
