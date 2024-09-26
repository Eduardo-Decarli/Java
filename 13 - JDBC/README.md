# JDBC

## O que é o JDBC

JDBC (Java Database Connectivity) é uma API (Application Programming Interface) do Java que permite conectar e interagir com diferentes bancos de dados de maneira padronizada. Ele fornece métodos para executar operações como consultas e atualizações em bancos de dados relacionais (como MySQL, PostgreSQL, Oracle, etc.) a partir de uma aplicação Java.

## Caracteristicas do JDBC

- Conexão com banco de dados: Estabelece a comunicação entre a aplicação Java e o banco de dados.
- Execução de consultas SQL: Permite que você envie comandos SQL para o banco de dados, como SELECT, INSERT, UPDATE e DELETE.
- Processamento de resultados: Recupera e manipula os dados retornados pelas consultas SQL.
- Gerenciamento de transações: Controla operações de transação (commit, rollback) para garantir a integridade dos dados.

## Estabelecendo Conexão com o DB

Para conectar-se a um banco de dados, você precisa de uma URL de conexão, nome de usuário e senha. A URL geralmente segue este formato: jdbc:<tipo_do_banco>://<host>:<porta>/<nome_do_banco>

Exemplo 

``` java

String url = "jdbc:mysql://localhost:3306/meu_banco";
String user = "root";
String password = "minha_senha";

Connection conexao = DriverManager.getConnection(url, user, password);

```
Aqui, o método DriverManager.getConnection() cria a conexão com o banco de dados.


## Fazendo Consultas Simples

Depois de estabelecer a conexão, você pode preparar e executar consultas SQL. Existem duas formas principais de fazer isso:

### Usando o Statement

``` java

Statement stmt = conexao.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM clientes");

```

### Usando o PreparedStatement

Usar PreparedStatement é mais seguro contra ataques de injeção de SQL.

``` java

String query = "INSERT INTO clientes (nome, idade) VALUES (?, ?)";
PreparedStatement pstmt = conexao.prepareStatement(query);
pstmt.setString(1, "João");
pstmt.setInt(2, 25);
pstmt.executeUpdate();

```