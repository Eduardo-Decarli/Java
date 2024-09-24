# Interfaces em Java

## O que é uma Interface?

Uma interfaceé uma " classe completamente abstrata " que é usada para agrupar métodos relacionados com corpos vazios.
Ela interface “obrigar” a um determinado grupo de classes que à implementam a ter métodos ou propriedades em comum para existir em um determinado contexto, contudo os métodos podem ser implementados em cada classe de uma maneira diferente. Pode-se dizer, a grosso modo, que uma interface é um contrato que quando assumido por uma classe deve ser implementado.

Dentro das interfaces existem somente assinaturas de métodos e propriedades, cabendo à classe que a utilizará realizar a implementação das assinaturas, dando comportamentos práticos aos métodos.

Uma interface é semelhante a uma classe, mas com as seguintes diferenças:

- **Não pode conter implementações concretas de métodos** (exceto métodos `default` e `static`)
- **Todos os métodos são, por padrão, públicos e abstratos**
- **Não pode ser instanciada diretamente**.

## Sintaxe de Declaração de Interface

A declaração de uma interface é feita usando a palavra-chave `interface`. Veja um exemplo de sintaxe:

```java
public interface Animal {
    void emitirSom(); // Método abstrato
}

```

## Uso

Interfaces são um dos principais mecanismos que Java oferece para atingir abstração, polimorfismo e flexibilidade no design de sistemas. Ao utilizar interfaces, você define contratos claros que podem ser implementados de diferentes maneiras, promovendo a reutilização de código e facilitando a manutenção.

- **Herança Múltipla:** Como Java não suporta herança múltipla entre classes, interfaces permitem que uma classe "herde" comportamentos de múltiplos tipos.

- **Polimorfismo:** Interfaces permitem que classes diferentes sejam tratadas de forma uniforme, permitindo polimorfismo. Por exemplo, um método que aceita um parâmetro do tipo Animal pode trabalhar com qualquer objeto de uma classe que implemente essa interface.

- **Separação de Comportamento:** Interfaces ajudam a separar o "o que" uma classe deve fazer do "como" isso é feito, promovendo um design mais flexível e desacoplado.
