package application;

import java.util.Scanner;

import services.PrintService;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Aqui declaramos um objeto PrintService de tipo Integer, mas como a classe PrintService é de um tipo genérico, ao inves de Integer, poderia ser qualquer outro tipo
        PrintService<Integer> ps = new PrintService<>();

        System.out.print("How many values? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            Integer value = sc.nextInt();
            ps.addValue(value);
        }

        ps.print();
        Integer x = ps.first();
        System.out.println("First: " + x);

        sc.close();
    }
}