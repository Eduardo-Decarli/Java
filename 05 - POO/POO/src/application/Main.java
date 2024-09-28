package application;
import entities.Triangle;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        //Aqui nós criamos duas variaveis do tipo Triangle
        Triangle x, y;
        //E aqui nós instanciamos essas variaveis, declaramos que as variaveis do tipo triangle, são novos triangle
        x = new Triangle();
        y = new Triangle();

        System.out.println("Digite os 3 lados do Triangulo X");
        //Aqui definimos os atribuitos do triangulo X
        x.a = sc.nextDouble();
        x.b = sc.nextDouble();
        x.c = sc.nextDouble();

        System.out.println("Digite os 3 lados do Tringulo Y");
        //Aqui definimos os atributos do triangulo Y
        y.a = sc.nextDouble();
        y.b = sc.nextDouble();
        y.c = sc.nextDouble();

        //Aqui fazemos a chamada ao método area de Triangle
        double areaX = x.area();
        double areaY = y.area();

        System.out.println(x.toString());


    }
}