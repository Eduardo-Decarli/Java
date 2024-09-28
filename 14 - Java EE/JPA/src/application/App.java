package application;

import dominio.Pessoa;

public class App {
    public static void main(String [] args){
    Pessoa p1 = new Pessoa(1, "Carlos", "Calrlossilva@gmail.com");
    Pessoa p2 = new Pessoa(2, "Joaquim Torres", "Joaquim@gmail.com");
    Pessoa p3 = new Pessoa(3, "Ana Maria", "ana@gmail.com");

    System.out.println(p1);
    System.out.println(p2);
    System.out.println(p3);
    }
}
