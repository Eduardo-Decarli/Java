# Inversão de Controle (IoC) e Injeção de Dependências (DI) em Java

## Inversão de Controle (IoC)

**Inversão de Controle (IoC)** é um princípio de design que altera a maneira como a responsabilidade de criar e gerenciar objetos é tratada em um sistema. Em vez de os próprios objetos controlarem suas dependências, esse controle é delegado para um contêiner externo, o que resulta em maior flexibilidade e um design mais modular.

No padrão tradicional, um objeto cria e gerencia suas dependências diretamente. Com IoC, essa responsabilidade é invertida, ou seja, outro componente (geralmente um framework ou contêiner IoC) cria e injeta essas dependências.

### Vantagens da Inversão de Controle

- **Desacoplamento**: Ao remover a responsabilidade de criar dependências de dentro da classe, você desacopla o código, facilitando alterações e manutenções.
- **Testabilidade**: O código se torna mais fácil de testar, já que dependências podem ser substituídas por objetos mock ou stubs durante testes.
- **Flexibilidade**: Com IoC, é mais fácil alterar o comportamento de uma classe, modificando apenas a injeção das dependências.

### Implementação de IoC

Em Java, frameworks como o **Spring** fornecem contêineres IoC que gerenciam automaticamente a criação de objetos e suas dependências, injetando-os quando necessário.

## Injeção de Dependências (DI)

**Injeção de Dependências (DI)** é um dos mecanismos mais comuns de IoC. Ele permite que uma classe receba as dependências de que precisa de um contêiner externo, em vez de criá-las manualmente dentro da classe. Isso melhora a modularidade, flexibilidade e testabilidade do código.

### Tipos de Injeção de Dependências

1. **Injeção via Construtor**: As dependências são passadas para a classe por meio de seu construtor.
   
   ```java
   public class Servico {
       private Repositorio repositorio;

       // Dependência injetada via construtor
       public Servico(Repositorio repositorio) {
           this.repositorio = repositorio;
       }

       public void realizarAcao() {
           repositorio.salvar();
       }
   }
