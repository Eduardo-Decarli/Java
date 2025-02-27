# Internação de String

A Internação de Strings (String interning) é um processo no qual o Java armazena Strings idênticas em um pool de Strings para evitar a duplicação e economizar memória. Sempre que uma String literal é criada, o Java verifica se ela já existe no String Pool. Se existir, ele reutiliza a referência, ao invés de criar um novo objeto.

Isso melhora o desempenho e reduz o consumo de memória, pois múltiplas variáveis podem apontar para a mesma instância de String.

## Conceitos Fundamentais

**String Pool:** Uma área especial na memória da **JVM** onde Strings são armazenadas para **reutilização**. Strings criadas como **literais** ("texto") são automaticamente adicionadas ao pool. Strings criadas com **new String("texto")** não vão automaticamente para o pool.

**Método **intern()**:** Força uma String a ser armazenada no pool de Strings. Se a String já estiver no pool, retorna a referência existente. Se não estiver, adiciona a String ao pool.

## Exemplos Práticos

- Comparação entre String no Pool e fora dele

``` Java

public class TesteStringPool {
    public static void main(String[] args) {
        String s1 = "Java";  // Vai para o pool
        String s2 = "Java";  // Reutiliza a referência de s1
        String s3 = new String("Java"); // Criado fora do pool

        System.out.println(s1 == s2); // true (mesma referência)
        System.out.println(s1 == s3); // false (diferente, pois s3 está fora do pool)
    }
}

```

---

- Usando **intern()** para forçar o uso do **String Pool**

``` Java

public class TesteIntern {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = new String("Java").intern(); // Força entrada no pool

        System.out.println(s1 == s2); // true (agora ambas usam a mesma referência)
    }
}

```

---

- String concatenadas e o String Pool

``` Java

public class TesteConcatenacao {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "Ja" + "va"; // Otimizado pelo compilador
        String s3 = "Ja";
        String s4 = s3 + "va"; // Criado em tempo de execução, fora do pool

        System.out.println(s1 == s2); // true (ambas no pool)
        System.out.println(s1 == s4); // false (s4 não está no pool)
        System.out.println(s1 == s4.intern()); // true (agora s4 vai para o pool)
    }
}

```

## Boas Práticas

- Sempre que possível, prefira usar **literais** de String ("texto") para aproveitar o **String Pool**.

- Se precisar garantir que uma String esteja no pool, use **intern()**.

- Ao comparar Strings, use **.equals()** em vez de **==**, a menos que esteja verificando referências intencionalmente.
