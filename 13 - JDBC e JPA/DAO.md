# DAO

## O que é DAO

O padrão de projeto DAO (Data Access Object) é um dos padrões mais comuns em desenvolvimento de software, especialmente em aplicações que interagem com bancos de dados. Ele organiza o código responsável pelo acesso e manipulação de dados, separando a lógica de negócios da lógica de acesso aos dados, promovendo uma arquitetura mais limpa e fácil de manter.

## Qual o Objetivo?

O principal objetivo do padrão DAO é fornecer uma abstração clara e uma interface para a comunicação com a fonte de dados (como um banco de dados relacional), escondendo os detalhes de implementação do acesso a esses dados. Assim, a lógica de negócios não precisa se preocupar com os detalhes específicos de como os dados são armazenados ou recuperados.

## Estrutura de dados

Interface DAO: Define os métodos que o objeto DAO vai implementar. Esses métodos descrevem as operações que podem ser feitas no banco de dados, como inserir(), atualizar(), deletar(), e buscar().

``` java

public interface ClienteDAO {
    void inserir(Cliente cliente);
    void atualizar(Cliente cliente);
    void deletar(int id);
    Cliente buscarPorId(int id);
    List<Cliente> buscarTodos();
}

```