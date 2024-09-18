import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) {
        String path = "/home/eduardo-decarli/Documentos/Programação/in.txt";

        //Instancia os objetos de cada classe
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
}