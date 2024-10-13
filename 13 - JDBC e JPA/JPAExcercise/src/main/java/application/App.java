package application;

import entities.Pessoa;
import services.StudentService;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa(null, "teste", LocalDate.now());

        System.out.println("Pronto");
    }
}
