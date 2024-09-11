public class Main {
    public static void main(String[] args) {
        /* While */
        int contador = 1;
        //Enquanto i for menor que 10, ele irá executar o escopo
        while(contador<10){
            contador++;
            System.out.println(contador);
        }

        /* for */
        //Estrutura for funciona da seguinte forma for(início; condição; incremento;){função}
        for(int i = 0; i < 10; i++){
            System.out.println(i);
        }

        /* do-while */
        //Essa estrutura primeiro executa o bloco de comando e depois verifica a condição, então mesmo se a condiçao for false, ele irá executar pelo menos uma vez
        int j = 10;
        do {
            System.out.println(10);
            j--;
        }while(j > 1);

    }
}