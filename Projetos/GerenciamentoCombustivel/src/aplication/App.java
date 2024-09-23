package aplication;

import entities.Account;
import entities.Client;
import exceptions.ClientExceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws ClientExceptions {
        Scanner sc = new Scanner(System.in);
        List<Account> account = new ArrayList<>();

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
        System.out.println("Bem Vindo " + client.getNome());

        System.out.println("Digite 1 para criar uma conta ou 2 para entrar em uma conta");
        controllerArrive = sc.nextInt();

        if(controllerArrive == 1){
            System.out.println("Conta corrente ou Conta poupança?");

            System.out.println("Digite o id da conta");
            int idAccount = sc.nextInt();
        }


    }
}

