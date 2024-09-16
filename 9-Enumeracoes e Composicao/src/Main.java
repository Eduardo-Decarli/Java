import entities.HourContract;
import entities.Worker;
import entities.WorkerLevel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("MM/yyyy");

        String deparment;
        String name;
        WorkerLevel level;
        double baseSalary;
        int quantContracts;

        System.out.print("Enter department's name: ");
        deparment = sc.nextLine();

        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        name = sc.nextLine();
        System.out.print("Level:  ");
        level = WorkerLevel.valueOf(sc.nextLine());
        System.out.print("Base Salary: ");
        baseSalary = sc.nextDouble();
        sc.nextLine();

        //Instancia o Worker
        Worker worker = new Worker(name, level, baseSalary);

        System.out.println("How many contracts to this worker?");
        quantContracts = sc.nextInt();
        sc.nextLine();

        for(int i = 1; i <= quantContracts; i++){
            System.out.printf("Enter contract #%s", i);
            System.out.println("Date (DD/MM/YYYY): ");
            String dataContract = sc.nextLine();
            LocalDate dataConvertida = LocalDate.parse(dataContract, fmt1);
            sc.nextLine();
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration(hours): ");
            int hoursContract = sc.nextInt();
            sc.nextLine();
            worker.addContract(new HourContract(dataConvertida, valuePerHour, hoursContract));
        }

        System.out.print("Enter month and year to calculate income(MM/YYYY): ");
        String dataIncomeString = sc.nextLine();
        dataIncomeString = "01/" + dataIncomeString;
        LocalDate dataIncome = LocalDate.parse(dataIncomeString, fmt1);

        System.out.println(worker.income(dataIncome.getYear(), dataIncome.getMonthValue()));
    }
}