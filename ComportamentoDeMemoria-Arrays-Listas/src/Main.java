import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /* Comportamento de Memória */
        //Variaveis de tipo objetos armazenam endereços para o heap da memória
        //Variaveis do tipo Objeto podem receber valores nulos
        Object p = null;
        //Variaveis de tipo primitivo armazenam o valor na célula respectiva da memória
        //Variaveis de tipo Primitivo não podem receber valores nulos

        //Quando alocamos (new) qualquer tipo estruturado (Classe ou Array), São atribuidos valores padrão, normalmente valores zero, null ou false
        Object objeto = new Object(); // Aqui por enquanto todos os possiveis atributos hipotéticos de objeto são nulos

        /* Vetor */

        Scanner sc = new Scanner(System.in);

        //Um vetor é uma lista continua e linear, com acesso mair rapido do que uma lista encadeada(ArrayList)
        //Declaração de Vetor é Feita da seguinte forma, primeiro definimos o tipo do vetor com chaves e declaramos que queremos instanciar um vetor, por fim, colocamos a quantidade de casas que o vetor terá
        int n = sc.nextInt();
        double[] vect = new double[n];

        //Normalmente utiliza-se uma estrutura de repetição para acessar as posições do vetor
        for(int i = 0; i < n; i++){
            vect[i] = sc.nextDouble();
            System.out.println(vect[i]);
        }

        /* Criando um Vetor de Objetos */
        //Aqui, supondo que n vale 3, criamos 3 elementos no heap vazios, pois ainda não receberam referencia para atributos, no momento são apenas objetos vazios
        Product[] vetorObjeto = new Product[n];

        for(int i = 0; i < vetorObjeto.length; i++){
            sc.nextLine();
            String name = sc.nextLine();
            double price = sc.nextDouble();
            //Agora a posição na memória que estava vazia, recebeu um valor referencia para os atributos name e price
            vetorObjeto[i] = new Product(name, price);
        }

        /* Laço ForEach */
        //For Each é uma forma de se percorrer coleções sem precisar estruturar o for por completo
        //X recebe o valor contido na posição respectiva de vetorObjeto, e não sua posição atual
        for(Product x:vetorObjeto){
            System.out.println(x);
        }

        /* Listas */
        //Uma variavel do tipo lista não pode ser instanciada por que o tipo List é uma interface em java,
        // então precisa de uma outra classe para implementar, tais classes como ArrayList, LinkedList, etc...
        List<String> lista = new ArrayList<>();

        //Retorna o tamanho da Lista
        lista.size();

        //Inserir elemento na Lista
        lista.add("a");
        lista.add(4, "teste"); //Adiciona o objeto na quarta posição

        //Remover elemento da Lista
        lista.remove("teste");
        lista.remove(2); // remove o index 2 na lista
        lista.removeIf(x -> x.charAt(0) == 'T'); //O elemento X busca na lista qualquer caractere que começe com a letra T e remove ele

        //Encontrar posição de elementos
        lista.indexOf(5);
        lista.indexOf("a"); //Busca na lista pelo valor 'a', se ele não encontrar, irá retornar -1

        //Filtrar lista com base em predicado
        List<String> result = lista.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());

        //Encontrar primeira ocorrencia com base em predicado
        String nome = lista.stream().filter(x -> x.charAt(0) == 'T').findFirst().orElse((null));

        /* Matrizes */
        int[][] matriz = new int[10][9];
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz.length; j++){
                matriz[i][j] = 10; //Agora a matriz na linha i e coluna j receberá o valor 10
            }
        }
    }
}