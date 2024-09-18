import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* BitWise */
        int n1 = 89;
        int n2 = 60;
        System.out.println(n1 & n2); //Irá retornar 24, pois a o uso da porta lógica AND nos bits desses numeros dá o resultado de 24 em binário
        System.out.println(n1 | n2); //Irá retornar 125, pois a portal lógica OU nos bits dos numeros resultam no numero 125 em binário
        System.out.println(n1 ^ n2); //Irá retornar 101, pois o uso da porta OU EXCLUSIVO retorna 101

        /* Funções String */

        String texto = "Olá, tudo bem?  ";

        //Formatação
        texto.toUpperCase(); //Torna a letra em maiuscula
        texto.toLowerCase(); //Torna a letra em minuscula
        texto.trim(); //Retira expaçamento das estremidades da String

        //Recorte
        texto.substring(2); //Gera uma nova String do caractere na posição 2 em diante do vetor de String
        texto.substring(2, 6); //Gera uma nova String que começa no caractere 2 e finaliza no caractere 6 da String

        //Substituição
        texto.replace('t', 'ç'); //Sempre que o sistema encontrar um t, ele irá recolocar um ç no lugar
        texto.replace("tudo", "nada"); //Sempre que o sistema encontrar o termo "tudo" na String, ele irá substituir por "nada"

        //Busca
        int i = texto.indexOf("tu"); //Armazena na variavel i, o valor da posição da primeira ocorrencia no vetor aonde encontra o termo "tu"
        int j = texto.lastIndexOf("o"); //Armazena na variavel j, o valor da posição da ultima ocorrencia no vetor onde encontra o termo "o"

        String[] vect = texto.split(" "); //Irá armazenar no vetor o recorte das palavras toda vez que chega em um espaço
        String word1 = vect[0]; //Armazena o termo "Olá,"
        String word2 = vect[1]; //Armazena o termo "tudo"
        String word3 = vect[2]; //Armazena o termo "bem?"

        /* Criando uma Função */
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.nextLine();
        int b = sc.nextInt();
        sc.nextLine();
        int c = sc.nextInt();
        int result = max(a, b, c);
        resultShow(result);
    }

    /* Criando uma Função */

    //Aqui declaramos que a função max que criamos é publica, statica e retorna um inteiro
    //Public declara que a função pode ser visualizada por todas as classes do pacote
    //Static declara que a função não precisa ser instanciada com um objeto para ser usada
    //int significa que a função deve executar a lógica e retornar um numero do tipo inteiro
    public static int max(int a, int b, int c){
        if(a > b && a > c){
            System.out.printf("%s é maior do que %s e %s\n", a, b, c);
            return a;
        }else if(b > c){
            System.out.printf("%s é maior do que %s e %s\n", b, a, c);
            return b;
        }else{
            System.out.printf("%s é maior do que %s e %s\n", c, a, b);
            return c;
        }
    }

    public static void resultShow(int x){
        System.out.println(x);
    }

}