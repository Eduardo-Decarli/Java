//Importa a função Locale da biblioteca util do java
import java.util.Locale;
//Importa o Scanner
import java.util.Scanner;
//Importa a classe Math
import java.math.*;

//Cria uma classe
public class Main {
    //A Função main é responsavel por definir o ponto de inicio do programa
    public static void main(String[] args) {
        //Função responsavel por mostrar no console um valor
        System.out.println("Hello world!");

        /*Variaveis*/

        //Declara uma variavel do tipo inteiro
        int y = 32;
        double x = 3.1415;
        //Printa a variavel Y + X e quebra uma linha
        System.out.println(y + x);

        System.out.printf("%.2f%n", x+y);

        //Define a localização default da aplicação, nesse caso, irá trocar virgulas por pontos
        Locale.setDefault(Locale.US);
        //Delimitação de casas decimais atravez do printf
        //%.2f delimita duas casas decimais após a virgula
        //%n ou \n quebra a linha

        //Concatenação
        System.out.println("Resultado =" + x + " Metros" );
        //Concatenação com PrintF
        System.out.printf("Resultado %f Metros\n" ,x);
        //Concatenação com variaveis
        String nome = "Maria";
        int idade = 20;
        double renda = 2598.8423;
        System.out.printf("%s tem %d anos e ganha R$ %.2f reais\n", nome, idade, renda);

        //Casting
        int a = 5;
        int b = 4;
        double resultado = 0.0;

        /*Casting*/

        //Em uma divisão de numeros inteiros, o Java entende que o resultado terá que ser inteiro, mesmo a variavel resultado armazenando valores double
        //Para sair valores Double, precisamos fazer um casting de int para double, sem (double) o resultado é 1
        resultado = (double)5/4;
        System.out.println(resultado);

        //Outro caso seria esse

        double g = 3.25;
        //Para passar um valor double a uma variavel inteira, você precisa fazer o casting dela para int
        int h = (int)g;

        /*Entrada de dados pelo Console*/

        //Cria um objeto do tipo Scanner
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEscreva um nome: ");
        String valorRecebido = sc.next();
        System.out.print("\nDigite um Numero Inteiro: ");
        int numeroIntRecebido = sc.nextInt();
        System.out.print("\nDigite um valor Double: ");
        double numeroDoubleRecebido = sc.nextDouble();
        System.out.printf("O nome digitado foi %s, o numero inteiro digitado foi %s e o valor double foi %.2f", valorRecebido, numeroIntRecebido, numeroDoubleRecebido);
        sc.close();

        //Existe também buffer de linhas para se tratar usando o Scanner
        Scanner scanner = new Scanner(System.in);
        int valorX;
        String s1, s2, s3;
        //Isso limpa o buffer da linha, fazendo o nextInt() de x receber uma nova linha e não o conteudo passado anteriormente sem querer
        scanner.nextLine();
        x = scanner.nextInt();
        s1 = scanner.nextLine();
        s2 = scanner.nextLine();
        s3 = scanner.nextLine();

        System.out.print(x + "\n" + s1 + "\n" + s2 + "\n" + s3);

        /*Funções Matemáticas*/
        //A recebe raiz quadrada de Y
        double A = Math.sqrt(y);
        //B recebe potencia entre x elevado a y
        double B = Math.pow(x, y);
        //C recebe o valor absoluto de Y (Caso y for -4, ele ira retornar !4 ou seja 4)
        double C = Math.abs(y);
    }
}