package entities;

import exceptions.ClientExceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    private String nome;
    private Integer cpf;
    private String password;

    List<Account> accountsClient = new ArrayList<>();

    public Client() {
    }

    public Client(String nome, Integer cpf, String password) {
        this.nome = nome;
        this.cpf = cpf;
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public List<Account> getAccountsClient() {
        return accountsClient;
    }

    //Função para salvar o novo usuario
    public void createClient() throws ClientExceptions {
        String path = "/home/eduardo-decarli/Documentos/in.txt";
        File createClientFile = new File(path);

        if(createClientFile.canWrite()){
            FileWriter fw = null;
            try {
                //Função que pula uma linha antes de escrever o usuario
                fw = new FileWriter(createClientFile, true);
                fw.write(this.nome + "," + this.password + "," + this.cpf);
            }
            catch(IOException x){
                throw new ClientExceptions("Houve um erro ao cadastrar o cliente: " + x.getMessage());
            }
            finally {
                try {
                    fw.close();
                }
                catch(IOException x){
                    throw new ClientExceptions("Erro ao fechar o arquivo: " + x.getMessage());
                }
            }
        }
    }

    public static Client consultUser(String name, String password) throws ClientExceptions {
        String path = "/home/eduardo-decarli/Documentos/in.txt";
        Scanner sc = null;
        try {
            sc = new Scanner(new File(path));
            String line = "";
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                String[] contentLine = line.split(",");
                if (contentLine[0].equals(name) && contentLine[1].equals(password)) {
                    return new Client(contentLine[0], Integer.parseInt(contentLine[2]), contentLine[1]);
                }
            }
        }
        catch(FileNotFoundException e){
            throw new ClientExceptions("Erro ao consultar o cliente: " + e.getMessage());
        }
        finally {
            sc.close();
        }
        return null;
    }

    public void createAccountUser(Account account){
        accountsClient.add(account);
    }

    public String consultAccount(){
        if(accountsClient.size() != -1){
            for(Account x : accountsClient){
               return x.toString();
            }
        }
        return "";
    }

    public String toString(){
        return "Usuario: " + nome
                + "\nCPF: " + cpf;
    }
}
