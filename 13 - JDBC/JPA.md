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

}

```

- A anotação **@Entity** define a classe como uma entidade JPA.

- @Table(name = "produtos") especifica o nome da tabela correspondente no banco de dados (opcional, pois a tabela seria criada com o nome da classe se omitido).

- @Id marca o campo id como a chave primária da entidade.

## Marcações JPA

- @Entity: Marca a classe como uma entidade JPA, mapeando ela como tabela no banco de dados.

- @Table: Define a tabela como a entidade que representa. Se não for especificada, a tabela terá o nome da classe.

- @Id: Define a chave primária da tabela.

- @GeneratedValue: Especifica como o valor da chave primária será gerado, pode receber os atributos: **AUTO, IDENTITY, SEQUENCE ou TABLE**.

- @Column: Especifica o mapeamento de um campo para uma coluna. Pode definir o nome da coluna, a nulabilidade, o comprimento máximo, entre outros.

- @OneToMany, @ManyToOne, @OneToOne, @ManyToMany: Mapemanto de relações entre as entidades.

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

### Configurando o JPA

Para utilizar o JPA, você deve configurar o persistence.xml, onde é definida a unidade de persistência.

``` XML

<persistence-unit name="MyPU">
    <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
    <properties>
        <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/meubanco"/>
        <property name="javax.persistence.jdbc.user" value="root"/>
        <property name="javax.persistence.jdbc.password" value="senha"/>
        <property name="hibernate.hbm2ddl.auto" value="update"/>
    </properties>
</persistence-unit>


```