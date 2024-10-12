# JDBC

## O que é o JDBC

JDBC (Java Database Connectivity) é uma API (Application Programming Interface) do Java que permite conectar e interagir com diferentes bancos de dados de maneira padronizada. Ele fornece métodos para executar operações como consultas e atualizações em bancos de dados relacionais (como MySQL, PostgreSQL, Oracle, etc.) a partir de uma aplicação Java.

### Caracteristicas do JDBC

- Conexão com banco de dados: Estabelece a comunicação entre a aplicação Java e o banco de dados.

- Execução de consultas SQL: Permite que você envie comandos SQL para o banco de dados, como SELECT, INSERT, UPDATE e DELETE.

- Processamento de resultados: Recupera e manipula os dados retornados pelas consultas SQL.

- Gerenciamento de transações: Controla operações de transação (commit, rollback) para garantir a integridade dos dados.

## Estrutura do JDBC

A  arquitetura do JDBC segue um modelo de 4 camadas principais. Cada uma dessas camadas tem sua função no processo de comunicação entre a aplicação Java e o banco de dados.

### Driver Menager (Gerenciador de Drivers)

O DriverManager é responsável por gerenciar uma lista de drivers de banco de dados e, com base nas informações fornecidas pela aplicação (como URL do banco, usuário, senha), selecionar o driver apropriado para estabelecer a conexão.

- Ele pertence a classe **java.sql.DriverManager**

- Tem a função de gerenciar drivers e estabelece conexões com o banco de dados.

- Método Principal: **DriverManager.getConnection()**

``` java

Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/meuBanco", "usuario", "senha");

```

### Connection (Conexão)

A interface Connection **(java.sql.Connection)** representa a conexão ativa com o banco de dados. Através dela, você pode criar consultas, gerenciar transações e obter informações sobre o banco de dados.

- Serve para estabelecer conexão com o banco de dados.

- Métodos Princiapis: 

    - createStatement(): Cria um objeto Statement para executar consultas SQL.

    - prepareStatement(): Cria um objeto PreparedStatement para consultas SQL parametrizadas.

    - commit() e rollback(): Gerencia transações.

``` java

Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/meuBanco", "usuario", "senha");
Statement statement = connection.createStatement();

```

### Statement

O **Statement** é responsável por executar as consultas SQL no banco de dados. Ele é utilizado tanto para comandos SQL dinâmicos como **SELECT, INSERT, UPDATE, DELETE**, quanto para **DDL** (Data Definition Language) como **CREATE TABLE**

- Interfaces Principais
    - java.sql.Statement
    - java.sql.PreparedStatement (Para consultas parametrizadas)
    - java.sql.Callablestatement (Para chamadas e stored procedures)

- Função: Enviar consultas SQL ao banco de dados

- Métodos principais:
    - executeQuery(): Executa uma consulta SELECT e retorna um ResultSet

    - executeUpdate(): Executa um comando INSERT, UPDATE, DELETE e retorna o número de linhas afetadas.

``` java

Statement statement = connection.createStatement();
ResultSet resultSet = statement.executeQuery("SELECT * FROM clientes");

```

### ResultSet(Conjunto de Resultados)

O ResultSet contém os dados retornados de uma consulta **SELECT**. Ele funciona como um cursor que permite iterar sobre os dados linha por linha.

- Interface Principal: java.sql.ResultSet

- Função: Armazenar os resultados de uma consulta e permite acessar os dados linha por linha

- Métodos principais

    - next(): Move o cursor para a próxima linha do DB

    - getString(), getInt, etc.: Usados para aceessar os valores das colunas por tipo

``` java

ResultSet resultSet = statement.executeQuery("SELECT nome, idade FROM clientes");
while (resultSet.next()) {
    String nome = resultSet.getString("nome");
    int idade = resultSet.getInt("idade");
    System.out.println("Nome: " + nome + ", Idade: " + idade);
}

```

## Estabelecendo Conexão com o DB

Para conectar-se a um banco de dados, você precisa de uma URL de conexão, nome de usuário e senha. A URL geralmente segue este formato: jdbc:tipo_do_banco://host:porta/nome_do_banco

Exemplo 

``` java

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/jdbc_test";
        String username = "root";
        String password = "your_password";

        try {
            // Estabelecendo a conexão
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Conexão bem-sucedida!");
            
            // Fechar a conexão
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


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