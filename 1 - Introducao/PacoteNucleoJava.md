# Pacotes que Formam o Java

O java é divido em hierarquia e organizado em pacotes, cada pacote do java, carrega com sigo uma gama de classes com funcionalidades primárias para o java, os pacotes padrões do java não precisam explicitamente serem evocados no momento de usar um atributo, apenas importados no código.

## Alguns Pacotes do Java

### java.lang

O pacote java.lang é parte do núcleo da linguagem Java e contém classes fundamentais para a programação em Java. Ele é automaticamente importado em todos os programas Java, ou seja, você não precisa importar explicitamente esse pacote para usar as classes que ele contém.

#### Classes Principais do java.lang

- Object: É a classe raiz de todas as classes em Java. Todas as classes herdam diretamente ou indiretamente desta classe. Ela fornece métodos como equals(), hashCode(), toString(), entre outros.

- String: Classe que representa cadeias de caracteres. Como as strings são usadas com frequência, a classe String tem funcionalidades poderosas para manipulação de texto.

- Math: Fornece métodos matemáticos como sin(), cos(), sqrt(), pow(), entre outros, para realizar operações matemáticas comuns.

- Integer, Double, Float, Boolean, Long: Classes empacotadoras (wrappers class) para tipos primitivos, permitindo que esses tipos sejam tratados como objetos.

- Thread: Classe para criar e controlar threads (fluxos de execução) em Java.

- System: Contém métodos úteis para acessar recursos do sistema, como entrada e saída padrão (System.out, System.in) e métodos para manipulação de propriedades do sistema e gerenciamento de memória.

- Exception, RuntimeException, Error: Classes relacionadas ao tratamento de exceções e erros no Java.

Essas classes são essenciais para a maioria dos programas Java, pois oferecem funcionalidades que são frequentemente necessárias para a maioria das aplicações.

### java.util

Nesse pacote, possui classes e interfaces que ajudam a trabalhar com grupos e listas de objetos (coleções) e oferecem diversas operações, como adição, remoção e busca de elementos, as classes e interfaces são: 

- List: Interface que representa uma lista de elementos, onde a ordem de inserção é mantida. Implementações comuns:

ArrayList: Lista baseada em array, muito eficiente para acessos rápidos.
LinkedList: Lista encadeada, melhor para operações de inserção e remoção.
