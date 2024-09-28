import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Instanciação da classe File
        File file = new File("/home/eduardo-decarli/Documentos/Programação/");
        Scanner sc = null;
        try {
            //tenta fazer o scanner ler o arquivo
            sc = new Scanner(file);
            //Enquanto houver uma proxima linha, ele irá printar a linha
            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            if(sc != null) {
                sc.close();
            }
        }
    }
}