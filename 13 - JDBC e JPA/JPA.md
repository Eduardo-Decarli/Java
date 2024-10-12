# JPA

## O que é o JPA

O JPA (Java Persistence API) é uma especificação da Java EE (Enterprise Edition) para o **mapeamento objeto-relacional (ORM)**. Ele facilita o trabalho com bancos de dados relacionais, permitindo que você manipule dados em um banco de dados usando objetos Java em vez de consultas SQL diretas.

JPA não é um framework, mas sim uma especificação. Ou seja, para usá-la, você precisa de uma implementação concreta, como Hibernate, EclipseLink ou OpenJPA. Cada um desses provedores oferece recursos além dos padrões da JPA, mas todos seguem as regras especificadas.

### Fundamentos do JPA

- Mapeamento Objeto-Relacional (ORM): Com o JPA, você pode mapear classes Java para tabelas em um banco de dados relacional. Isso é feito através de **anotações** (@Entity, @Table, @Id, etc.), que indicam como os campos de uma classe se relacionam com as colunas de uma tabela.

- Persistência: O JPA fornece uma maneira simples de **persistir (armazenar)** objetos no banco de dados. Ao invés de escrever SQL para inserir, atualizar ou deletar dados, você trabalha diretamente com os objetos Java.

- Consultas (JPQL): JPA possui sua própria linguagem de consultas, chamada JPQL (Java Persistence Query Language), que é similar ao SQL, mas trabalha diretamente com as entidades Java, em vez de tabelas.

- Gerenciamento de Transações: Ele permite gerenciar transações de banco de dados de forma simplificada, garantindo que as operações de persistência sejam realizadas de forma segura.

### Arquitetura Básica

- Entidades: As entidades são classes Java que representam tabelas no banco de dados. Cada **instância de uma entidade corresponde a uma linha na tabela**. Essas classes são anotadas com **@Entity** e contêm os atributos que representam as colunas da tabela.

``` java 

@Entity //Define que a classe será uma tabela
public class Book {
    @Id // Define que o atributo abaixo será um ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Marca o ID como um indentificador para o objeto
    private Long id;
    
    private String title;
    private String author;
}

```

- EntityManager: O Entity Manager é o componente central do JPA que gerencia as entidades. Ele é responsável por realizar operações de persistência no banco de dados, como salvar, buscar, atualizar e remover entidades.

``` java 

EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit"); // Instancia um criador de EntityManager
EntityManager em = emf.createEntityManager(); // Instancia o próprio EntityManager

em.getTransaction().begin(); // Tudo que não for uma busca no DB precisa de uma transação, e assim declaramos uma transação pois isso dá mais segurança ao alterar dados no DB.

// Persistindo um novo objeto
Book book = new Book();
book.setTitle("Java Persistence");
book.setAuthor("Autor X");

em.persist(book); // Metodo persist() salva o objeto book no banco de dados

em.getTransaction().commit(); //Aqui confirmamos a transação
em.close(); // Fechamento do EntityManager

```

- Persistence Context: Conjunto de entidades gerenciadas pelo **EntityManager**. Ele garante que uma entidade só tenha uma única instancia gerenciada em determinado contexto.

- Repositórios: São classes ou interfaces que contêm a lógica de persistência e consulta das entidades.

- A anotação **@Entity** define a classe como uma entidade JPA.

- @Table(name = "produtos") especifica o nome da tabela correspondente no banco de dados (opcional, pois a tabela seria criada com o nome da classe se omitido).

- @Id marca o campo id como a chave primária da entidade.

- Persistence Unit (Unidade de Persistência): A Unidade de Persistência define as configurações do JPA, como o banco de dados que será utilizado, o provedor de JPA (Hibernate, EclipseLink, etc.), e outras propriedades. Essas configurações são especificadas no arquivo persistence.xml. 

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

## Configurando o JPA

Para utilizar o JPA, você deve configurar um arquivo chamado persistence.xml, onde é definida a unidade de persistência.

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

## Entidades e Mapeamentos Objeto-Relacional

As entidades JPA são simples classes Java que representam uma tabela no banco de dados.

## Consultas com JPQL (Java Persistence Query Language)

JPQL é uma linguagem de consultas orientadas a objetos que funciona como entidades JPA, permitindo consultas mais avançadas.

``` java 

String jpql = "SELECT b FROM Book b WHERE b.title = :title";
TypedQuery<Book> query = em.createQuery(jpql, Book.class);
query.setParameter("title", "The Hobbit");
List<Book> books = query.getResultList();

```

## Gerenciamento do Ciclo de Vida das Entidades

O JPA tem estados especificos para as entidades

- New: Quando a entidade foi criada, mas ainda não está persistida no banco.

- Managed: A entidade está sendo gerenciada pelo contexto de persistência.

- Detached: A entidade foi desanexada do contexto de persistência.

- Removed: A entidade foi marcada para remoção.

## Operações CRUD no JPA

## Relacionamentos entre Entidades

## Henraça no JPA

## Transações no JPA

## Caching e Performance no JPA

## Critérios de Consultas (Criteria API)

## Exceções Comuns no JPA