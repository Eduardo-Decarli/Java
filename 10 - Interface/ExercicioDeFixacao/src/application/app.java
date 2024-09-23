package application;

import entities.Contract;
import entities.Installment;
import services.ContractService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class app {
    public static void main(String[] args) {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Entre os dados do contrato: ");
        System.out.print("Numero: ");
        int idContract = sc.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.nextLine(), fmt);
        System.out.print("Valor do contrato: ");
        double contractValue = sc.nextDouble();

        Contract contract = new Contract(idContract, date, contractValue);

        System.out.println("Entre com as parcelas: ");
        int quantInstallment = sc.nextInt();

        ContractService cs = new ContractService(null);
        cs.processContract(contract, quantInstallment);

        System.out.println("PARCELAS");
        for(Installment installment : contract.getInstallments()){
            System.out.println(installment);
        }


    }
}