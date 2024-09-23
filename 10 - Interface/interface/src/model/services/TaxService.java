package model.services;

//Uma interface declara que as classes que implementarem a interface, irão cumprir o contrato de implementar suas funções, assim, pode-se instanciar as classes que implementam a interface e será feito upcastiong,
//nesse caso, RentalService tem um acoplamento forte com interface, mas fraca com a classe BrazilTaxService

//Para criar uma interface, fazemos dessa forma, declarando que a classe é uma interface
public interface TaxService {

    //Aqui declaramos que todas as classes que implementarem a interface, farão o contrato de implementar essa função
    double tax(double amount);
}
