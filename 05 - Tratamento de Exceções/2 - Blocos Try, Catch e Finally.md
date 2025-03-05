# Blocos try, catch, finally em Java

O Java oferece os blocos try, catch e finally para lidar com exceções de forma estruturada e segura. Esses blocos garantem que erros sejam tratados corretamente e que recursos importantes sejam liberados, independentemente do que aconteça durante a execução do código.

- **try** → Bloco onde o código que pode gerar exceções é executado.
- **catch** → Captura e trata a exceção se ocorrer.
- **finally** → Código que será executado sempre, independentemente de exceções.

## Conceitos Fundamentais

**try – Bloco de Código Protegido:** O bloco try contém o código que pode gerar uma exceção. Se uma exceção for lançada dentro do **try**, a execução pula para o bloco **catch**.

**catch – Tratando Exceções:** O bloco **catch** captura a exceção e executa o código de tratamento adequado. Podemos ter múltiplos blocos **catch** para tratar diferentes tipos de exceções.

**finally – Executado Sempre:** O bloco **finally** é usado para código que deve ser executado independentemente de ocorrer uma exceção ou não. Geralmente, é usado para liberar recursos como arquivos, conexões de banco de dados, etc.

``` Java

// Uso básico do try e catch

public class TryCatchExample {
    public static void main(String[] args) {
        try {
            int resultado = 10 / 0; // Isso gera uma ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Erro: Não é possível dividir por zero.");
        }
        System.out.println("Programa continua após o catch.");
    }
}

// Exemplo Usando Finally

public class TryCatchFinallyExample {
    public static void main(String[] args) {
        try {
            int[] numeros = {1, 2, 3};
            System.out.println(numeros[5]); // Gera ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: Índice fora dos limites do array.");
        } finally {
            System.out.println("Bloco finally: Sempre será executado.");
        }
    }
}

// Múltiplos catch para Diferentes Exceções

public class MultipleCatchExample {
    public static void main(String[] args) {
        try {
            String texto = null;
            System.out.println(texto.length()); // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Erro: Tentativa de acessar um objeto nulo.");
        } catch (ArithmeticException e) {
            System.out.println("Erro: Operação matemática inválida.");
        } finally {
            System.out.println("Bloco finally sempre executado.");
        }
    }
}

// finally para Fechamento de Recursos

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FinallyExample {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            File file = new File("arquivo.txt");
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo não encontrado.");
        } finally {
            if (scanner != null) {
                scanner.close();
                System.out.println("Scanner fechado.");
            }
        }
    }
}

```