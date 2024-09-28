import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        //Cria as linhas para se incluir no arquivo
        String[] lines = new String[]{"Good Morning", "Good Afternoon", "Good Night"};

        String path = "/home/eduardo-decarli/Documentos/Programação/out.txt";

        //Tenta instanciar o bufferedWriter e o FileWriter
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            //Percorre o vetor de String e escreve cada posição no arquivo
            for(String line : lines){
                bw.write(line);
                bw.newLine();
            }

            String diretorio = "/home/eduardo-decarli/Documentos/Programação";

            File filePath = new File(diretorio);

            File[] paths = filePath.listFiles(File::isDirectory);
            File[] files = filePath.listFiles(File::isFile);

            System.out.println("Folders: ");
            for(File x : paths){
                System.out.println(x);
            }
            for(File x : files){
                System.out.println(x);
            }
        }
        catch(IOException x){
            x.printStackTrace();
        }

    }
}