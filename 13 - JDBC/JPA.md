# JPA

## O que é o JPA

A Java Persistence API (JPA) é uma especificação do Java para acessar, gerenciar e persistir dados entre objetos Java e bancos de dados relacionais. Ela fornece uma abstração para trabalhar com entidades em Java, permitindo que você manipule os dados como objetos, sem se preocupar com os detalhes específicos de SQL.

JPA não é um framework, mas sim uma especificação. Ou seja, para usá-la, você precisa de uma implementação concreta, como Hibernate, EclipseLink ou OpenJPA. Cada um desses provedores oferece recursos além dos padrões da JPA, mas todos seguem as regras especificadas.

### Arquitetura Básica

- Entidades: Representa uma tabela no banco de dados. Cada instância de uma entidade é uma linha na tabela.

- EntityManager: Responsável por interagir com o BD e gerenciar o ciclo de vida das entidades.

- Persistence Context: Conjunto de entidades gerenciadas pelo **EntityManager**. Ele garante que uma entidade só tenha uma única instancia gerenciada em determinado contexto.

- Repositórios: São classes ou interfaces que contêm a lógica de persistência e consulta das entidades.

### Exemplo Prático

``` java

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    private Long id;

    private String nome;
    private Double preco;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}

```

- A anotação **@Entity** define a classe como uma entidade JPA.

- @Table(name = "produtos") especifica o nome da tabela correspondente no banco de dados (opcional, pois a tabela seria criada com o nome da classe se omitido).

- @Id marca o campo id como a chave primária da entidade.

## Mapeamento Objeto-Relacional

O mapeamento objeto-relacional (ORM) é o coração do JPA. Ele define como as classes Java são mapeadas para tabelas de banco de dados e como seus atributos correspondem às colunas. Aqui estão os principais conceitos e anotações que você deve conhecer:

- @Entity: Marca a classe como uma entidade JPA.

- @Table: Define a tabela como a entidade que representa. Se não for especificada, a tablema terá o nome da classe.

- @Id: Define a chave primária da tabela.

- @GeneratedValue: Configura a geração automática do valor da chave primária, pode receber os atributos: **AUTO, IDENTITY, SEQUENCE ou TABLE**.

- @Column: Especifica o mapeamento de um campo para uma coluna. Pode definir o nome da coluna, a nulabilidade, o comprimento máximo, entre outros.

### Exemplo

``` java

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_completo", nullable = false, length = 100)
    private String nome;

    @Column(unique = true)
    private String email;
}

```

### Relacionamento entre Entidades

No JPA, é possível modelar os relacionamentos entre tabelas usando as seguintes anotações:

- @OneToOne: Define um relacionamento um-para-um entre duas entidades