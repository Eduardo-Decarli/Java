# JPA

## Indice

[O que é JPA](#O-que-é-o-JPA)<br>
[Fundamentos](#fundamentos-do-jpa)<br>
[Arquitetura](#arquitetura-básica)<br>
[Principais Marcadores](#marcações-jpa)<br>
[Configurando o JPA](#configurando-o-jpa)<br>
[CRUD](#operações-crud-no-jpa)

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

As marcações no JPA (anotações) são usadas para definir como as classes Java e seus atributos são mapeados para tabelas e colunas no banco de dados, além de configurar o comportamento das entidades.

- @Entity: Marca a classe como uma entidade JPA, mapeando ela como tabela no banco de dados.

- @Table: Define a tabela como a entidade que representa. Se não for especificada, a tabela terá o nome da classe.

- @Id: Define a chave primária da tabela.

- @GeneratedValue: Especifica como o valor da chave primária será gerado, pode receber os atributos: **AUTO, IDENTITY, SEQUENCE ou TABLE**.

- @Column: Especifica o mapeamento de um campo para uma coluna. Pode definir o nome da coluna, a nulabilidade, o comprimento máximo, entre outros.

``` java

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "book_title", nullable = false, length = 100)
    private String title;

    @Column(name = "book_author")
    private String author;
}

```

- @OneToOne: Define um relacionamento de um para um entre duas entidades. Um exemplo clássico é um relacionamento entre Person e Passport, onde cada pessoa tem um passaporte único.

``` java

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "passport_id")
    private Passport passport;
}

```

- @OneToMany: Usada para definir um relacionamento de um para muitos. Esse é o caso quando uma entidade é associada a várias instâncias de outra entidade. Por exemplo, um autor pode ter vários livros.

``` java

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(mappedBy = "author")
    private List<Book> books;
}

```

- @ManyToOne: Define um relacionamento de muitos para um, como o lado inverso de @OneToMany. Cada livro tem um único autor, mas um autor pode ter muitos livros.

``` java

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
}


```

- @ManyToMany: 

Define um relacionamento de muitos para muitos entre duas entidades. Por exemplo, um livro pode ter muitos autores, e um autor pode ter escrito muitos livros. Nesses casos, geralmente é usada uma tabela associativa (join table).

``` java

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToMany
    @JoinTable(
        name = "author_book",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;
}

```

- @JoinColumn: É usada para especificar a coluna que será utilizada para unir duas entidades relacionadas. Ela define a coluna de chave estrangeira.

``` java

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}

```

- @Embedded e @Embeddable: A anotação @Embedded é usada quando você deseja incorporar uma classe dentro de uma entidade, mas sem criar uma tabela separada. A classe incorporada deve ser anotada com @Embeddable.

- @Transient: Indica que um campo não deve ser persistido no banco de dados. Ele será ignorado pelo JPA.

- @Lob: Essa anotação é usada para mapear tipos de dados grandes, como blobs (binários) ou clobs (textos longos).

``` java

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Lob
    private String description;  // Texto grande armazenado como CLOB
}

```

## Configurando o JPA

Para utilizar o JPA, o processo envolve basicamente três passos principais: **adicionar as dependências necessárias, configurar o arquivo de persistência e preparar as entidades**.

### Adicionar as Dependências

Se estiver utilizando Maven, adicione a dependência do JPA e do provedor (como Hibernate) no arquivo pom.xml

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

### Configurar o Arquivo

Você precisará criar um arquivo persistence.xml dentro da pasta META-INF para configurar as propriedades da persistência. Este arquivo define a unidade de persistência, que indica o banco de dados e as entidades gerenciadas pelo JPA.

``` XML

<persistence xmlns="https://jakarta.ee/xml/ns/persistence"
             version="3.0">
    <persistence-unit name="library-persistence-unit">
        <!-- Configuração do provedor -->
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>

        <!-- Entidades que o JPA irá gerenciar -->
        <class>com.example.model.Book</class>
        <class>com.example.model.Member</class>
        <!-- Adicione todas as classes de entidade aqui -->

        <!-- Propriedades de conexão com o banco de dados -->
        <properties>
            <!-- URL do banco de dados -->
            <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/library_db"/>
            <!-- Usuário e senha do banco de dados -->
            <property name="jakarta.persistence.jdbc.user" value="root"/>
            <property name="jakarta.persistence.jdbc.password" value="password"/>
            <!-- Driver JDBC -->
            <property name="jakarta.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
            
            <!-- Propriedades específicas do Hibernate -->
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect"/>
            <property name="hibernate.hbm2ddl.auto" value="update"/> <!-- "update", "validate", "create", etc. -->
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
        </properties>
    </persistence-unit>
</persistence>

```

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

### Create

Para inserir um novo registro no banco de dados, utilizamos o método persist do EntityManager.

``` java

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BookDao {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library-persistence-unit");

    public void createBook(Book book) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin(); // Inicia a transação
        
        entityManager.persist(book); // Persiste a nova entidade (Create)
        
        entityManager.getTransaction().commit(); // Confirma a transação
        entityManager.close(); // Fecha o EntityManager
    }
}


```

### Read

Para buscar dados no banco de dados, usamos o método find para buscar por chave primária ou a API de consultas do JPA (JPQL).

``` java

public Book findBookById(Long id) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    Book book = entityManager.find(Book.class, id); // Busca um livro pelo ID
    entityManager.close();
    return book;
}

```

### Update

Para atualizar um registro, usamos o método merge. O JPA atualiza uma entidade gerenciada pelo EntityManager, então, caso a entidade esteja fora do contexto de persistência (não gerenciada), usamos merge para trazê-la de volta ao estado gerenciado.

``` java

public void updateBook(Book book) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    
    entityManager.merge(book); // Atualiza a entidade (Update)
    
    entityManager.getTransaction().commit();
    entityManager.close();
}

```

### Delete

Para remover um registro do banco de dados, usamos o método **remove** do **EntityManager**, primeiro, você precisa buscar a entidade que deseja remover e, em seguida, chamar o método **remove**.

``` java

public void deleteBook(Long id) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    
    Book book = entityManager.find(Book.class, id); // Busca a entidade a ser deletada
    if (book != null) {
        entityManager.remove(book); // Remove a entidade
    }
    
    entityManager.getTransaction().commit();
    entityManager.close();
}

```

### Gerenciamento do EntityManager

O EntityManager é o ponto central das operações de persistência, e ele gerencia o ciclo de vida das entidades. Cada operação de escrita (inserção, atualização, remoção) deve ser realizada dentro de uma transação.

#### Boas práticas para gerenciar o EntityManager:

- Sempre inicie uma transação com entityManager.getTransaction().begin() antes de operações de escrita.

- Sempre finalize a transação com commit ou rollback, dependendo do sucesso ou falha da operação.

- Lembre-se de fechar o EntityManager depois que as operações forem concluídas para liberar recursos.

## Henraça no JPA

## Transações no JPA

## Caching e Performance no JPA

## Critérios de Consultas (Criteria API)

## Exceções Comuns no JPA