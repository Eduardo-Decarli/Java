package aplication;

import entities.Client;
import exceptions.ClientExceptions;

import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws ClientExceptions {
        Scanner sc = new Scanner(System.in);

        System.out.println("Seja bem vindo ao banco");
        System.out.println("Deseja se cadastrar ou fazer login?");
        System.out.print("Selecione 1 para login e 2 para cadastro: ");
        int controllerArrive = sc.nextInt();
        sc.nextLine();

        if (controllerArrive == 2) {
            System.out.println("--------------------");
            System.out.println("Sessão de cadastro");
            System.out.print("Digite seu nome: ");
            String name = sc.nextLine();
            System.out.print("Digite seu CPF: ");
            int cpf = sc.nextInt();
            sc.nextLine();
            System.out.print("Digite uma senha: ");
            String password = sc.nextLine();

            Client client = new Client(name, cpf, password);
            client.createClient();
        }


        System.out.println("--------------------");
        System.out.println("Sessão de Login");
        System.out.print("Digite o nome do usuario: ");
        String name = sc.nextLine();
        System.out.print("Digite a senha do usuario: ");
        String password = sc.nextLine();

        Client client = Client.consultUser(name, password);
        System.out.println("Bem Vindo" + client.getNome() + "CPF: " + client.getCpf());

    }
}

