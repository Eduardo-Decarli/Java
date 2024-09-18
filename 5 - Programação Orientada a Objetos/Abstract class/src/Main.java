import entities.Account;
import entities.BussinessAcount;
import entities.SavingsAccount;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Account acc1 = new Account(1001, "Alex", 1000.0); //Isso irá gerar erro pois Account é abstract
        Account acc2 = new BussinessAcount(1002, "Maria", 1000.0, 0.01);
        Account acc3 = new BussinessAcount(1006, "Bob", 254.4, 500.0);

        //Usando uma superclasse abstrata pode-se tratar melhor o reuso entre as subclasses e o upcasting e downcasting se mantem pertinentes
        List<Account> accList = new ArrayList<>();
        accList.add(acc2); //Embora acc2 e acc3 sejam de classes diferentes, podemos colocar na mesma lista pois são feitas a partir de uma classe genérica
        accList.add(acc3);

        double soma = 0.0;

        for(Account x : accList){
            soma += x.getBalance();
        }
        System.out.printf("Total balance: %.2f\n", soma);

    }
}