import entities.Account;
import entities.BussinessAcount;
import entities.SavingsAccount;

public class Main {
    public static void main(String[] args) {

        Account acc = new Account(1001, "Alex", 0.0);
        BussinessAcount bacc = new BussinessAcount(1002, "Maria", 0.0, 500.0);

        /* UPCASTING E DOWNCASTING */

        //UPCASTING
        //Dessa forma fazemos um upcasting de uma subclasse para uma superclasse
        Account acc1 = bacc;
        acc1.getBalance();
        //Como a herança é uma relação "é um", então uma subclasse é uma superclasse também, então upcasting entre elas é perfeitamente possivel
        Account acc2 = new BussinessAcount(1003, "Bob", 0.0, 200.0);
        Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 200.0);

        //DOWNCASTING
        //O DownCasting de uma super classe para uma subclasse não é um processo natural do java como o contrario, então precisamos forçar o Downcasting
        BussinessAcount acc4 = (BussinessAcount) acc2;
        acc4.loan(100.0);

        //Se BussinessAcount for uma instancia de acc3, ele permite retorna true
        if(acc3 instanceof BussinessAcount){
            BussinessAcount acc5 = (BussinessAcount) acc3;
            acc5.loan(200.0);
            System.out.println("Loan!");
        }

        if(acc3 instanceof SavingsAccount){
            SavingsAccount acc5 = (SavingsAccount) acc3;
            acc5.updateBalance();
            System.out.println("Update!");
        }

        /* Override */

        Account acc5 = new Account(1005, "Pablo", 1000.0);
        //Aqui desconta 5 reais no método de Account
        acc5.withdraw(200);
        System.out.println(acc5.getBalance());

        Account acc6 = new SavingsAccount(1007, "Maria", 1000.0, 0.01);
        //Aqui temos a sobreescrita do método withdraw na classe SavingsAccount e não é retirado o valor de 5 reais
        acc6.withdraw(200.0);
        System.out.println();

        Account acc7 = new BussinessAcount(1008, "Bob", 1000.0, 500.0);
        acc7.withdraw(200.0);
        System.out.println(acc7.getBalance());
    }
}