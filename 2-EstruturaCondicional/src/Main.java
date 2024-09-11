import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /* Expressão Comparativa */
        int x = 5;
        boolean comparativo = x>0; //Expressão retorna true
        comparativo = x == 3; //Expressão retorna false
        comparativo = 10<=30; //Expressão retorna true
        comparativo = x != 2; //Expressão retorna true

        /* Expressão Lógica */
        comparativo = x<20 && x == 5;//Retorna True
        comparativo = x<4 || x == 5;//Retorna true
        comparativo = !(x == 3);//Retorna true por que x não é igual a 3

        /* Estrutura condicional */
        if(x == 5){
            //Se a expressão der true, entra nesse bloco
        }else if(x == 3){
            //Se a expressão der true, entra nesse bloco
        }else{
            //Se nenhuma expressão for verdadeira, entra nesse bloco
        }

        //Podemos expressar um if de maneira resumida, chamada expressão ternaria
        //(condição)? true : false;
        x = (x == 5)? 3 : 4; //X agora é igual a 3

        /* Switch Case */
        System.out.print("Digite o valor 1 para domingo e assim por diante para os outros dias: ");
        int controle = sc.nextInt();
        sc.nextLine();
        switch(controle){
            case 1:
                System.out.println("Domingo");
                break;
            case 2:
                System.out.println("Segunda");
                break;
            case 3:
                System.out.println("Terça");
                break;
            case 4:
                System.out.println("Quarta");
                break;
            case 5:
                System.out.println("Quinta");
                break;
            case 6:
                System.out.println("Sexta");
                break;
            case 7:
                System.out.println("Sábado");
                break;
            default:
                System.out.println("Valor Inválido");
                break;
        }

        /* Escopo e Inicialização */

        double price;

        if(5<1){
            //Se declarar uma variavel dentro de um escopo, não poderá acessar ela fora do escopo
            price = 20;
        }else{
            //Para não dar erro, podemos declarar a variavel dessa forma, ou atribuir o valor 0 para ela no momento da inicialização da variavel
            price = 0;
        }

        System.out.println(price);
    }
}