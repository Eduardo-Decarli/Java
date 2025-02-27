# String, StringBuilder e StringBuffer

String são sequências de caracteres usadas para representar texto em Java. Elas são amplamente utilizadas para manipulação de dados, exibição de mensagens, entrada do usuário e muito mais.

O java oferece três classes principais para trabalhar com String: 

- **String:** Imutável (não pode ser alterada após a criação)

- **StringBuilder:** Mutável e não sincronizado (melhor desempenho).

- **StringBuffer:** Mutável e sincronizada.

## Conceitos Fundamentais

- **String (Imutável):** Uma vez criada, seu valor não pode ser alterado. Toda modificação cria um novo objeto na memória, são guardada no pool de String, economizando memória.

``` Java

String nome = "Java";
nome = nome + " é incrível!"; // Cria um novo objeto na memória

```

O objeto **Java** original continua na memória, mas nome agora aponta para um novo objeto **"java é incrível!"**.

- **StringBuilder (Mutável, não sincronizado):** Permite modificar string sem criar novos objetos, indicado para operações frequentes de concatenação. Possui melhor desempenho em aplicações simgle-thread.

``` Java

StringBuilder sb = new StringBuilder("Java");
sb.append(" é incrível!");
System.out.println(sb); // Saída: Java é incrível!

```

O conteúdo do **StringBuilder** é alterado sem criar novos objetos.

- **StringBuffer (Mutável, sincronizado):** Funciona como StringBuilder, mas é thread-safe, recomendado para aplicações multi-thread.

``` Java

StringBuffer sbf = new StringBuffer("Java");
sbf.append(" é incrível!");
System.out.println(sbf); // Saída: Java é incrível!

```