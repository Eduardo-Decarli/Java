import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* Try-Catch */
        Scanner sc = new Scanner(System.in);

        //Try tenta rodar o código
        try {
            String[] vect = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vect[position]);
        }
        //Catch captura as exceptions geradas dentro do try e pode criar lógica para mostrar para o usuario aonde acarretou o erro
        catch(ArrayIndexOutOfBoundsException x){
            System.out.println("Invalid position");
            //Esse método retorna o caminho onde foi acarretado o erro, se o erro foi gerado dentro de uma classe especifica, essa função pode ser util para fazer debug
            x.printStackTrace();
        }
        catch(InputMismatchException x){
            System.out.println("Input error");
        }
        //O bloco Finally é parte da estrutura do try-catch, esse bloco irá executar o que estiver dentro, independente se o try deu certo ou não
        finally {
            System.out.println("Bloco Finally ativado");
        }
        //Se houver um erro acima do código e não tiver a tratativa de erro, o código não termina, ou sejá, ele não exibirá essa mensagem
        System.out.println("End Program");
        sc.close();
    }
}