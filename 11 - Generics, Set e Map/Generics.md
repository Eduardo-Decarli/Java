# Generics

Generics em Java é um recurso que permite criar classes, interfaces e métodos que podem operar com tipos de dados diferentes, sem a necessidade de definir explicitamente esses tipos no momento da criação. Isso traz mais flexibilidade e reutilização de código, ao mesmo tempo que mantém a segurança de tipos (type safety).

Por exemplo, sem Generics, você teria que criar diferentes classes ou métodos para lidar com tipos de dados específicos, como Integer, String, etc. Com Generics, você pode escrever um código genérico, que funciona com qualquer tipo, mas ainda garante que os tipos corretos sejam usados durante a execução do programa.

## Exemplo Básico

``` java

public class Caixa<T> {
    private T objeto;

    public void adicionar(T objeto) {
        this.objeto = objeto;
    }

    public T pegar() {
        return objeto;
    }
}

```

Aqui, a classe Caixa usa um parâmetro de tipo T, que pode ser qualquer tipo de objeto. Ao criar uma instância dessa classe, você especifica o tipo de dado que ela deve armazenar.

<hr>

Aqui, a primeira Caixa especifica que o tipo de dado é Integer, enquanto a segunda Caixa usa String. Esse é o poder dos Generics: criar código que funciona com múltiplos tipos, mantendo a consistência e prevenindo erros de tipo.

``` java

public class TesteGenerics {
    public static void main(String[] args) {
        // Caixa para inteiros
        Caixa<Integer> caixaInteiro = new Caixa<>();
        caixaInteiro.adicionar(123);
        System.out.println("Caixa de Inteiro: " + caixaInteiro.pegar());

        // Caixa para strings
        Caixa<String> caixaString = new Caixa<>();
        caixaString.adicionar("Texto genérico");
        System.out.println("Caixa de String: " + caixaString.pegar());
    }
}

```

## Benefícios

- Segurança de tipos (Type safety): Os erros de tipo são detectados em tempo de compilação, evitando erros em tempo de execução.

- Reutilização de código: O mesmo código pode ser usado para diferentes tipos de dados, sem a necessidade de duplicar lógica para cada tipo.

- Remoção de "casts" explícitos: Com Generics, não é necessário fazer conversões explícitas, já que o tipo é inferido automáticamente.