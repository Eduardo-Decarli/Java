# O que é?

O padrão de projetos DTO (Data Transfer Object) é um padrão de projeto de software que visa transferir dados entre diferentes componentes de um sistema de forma eficiente e consistente.

O DTO é uma classe simples que normalmente contém apenas campos para armazenar dados e não possui comportamento (métodos). Ele é utilizado para encapsular e transportar dados entre camadas de um sistema, como a camada de apresentação, a camada de serviços e a camada de acesso a dados.

- Transferência eficiente de dados: Ao usar DTOs, é possível transferir apenas os dados necessários entre as camadas do sistema, reduzindo a quantidade de informações transmitidas e melhorando o desempenho.

- Separação de responsabilidades: O uso de DTOs ajuda a separar as responsabilidades das diferentes camadas do sistema. Cada camada pode ter seus próprios DTOs específicos, adequados para suas necessidades, sem expor diretamente os detalhes internos dos objetos de domínio.

- Versatilidade: Os DTOs podem ser usados para representar diferentes estruturas de dados, permitindo a flexibilidade na definição dos dados a serem transferidos. Isso é especialmente útil em sistemas complexos, onde diferentes partes do sistema podem exigir diferentes visualizações dos dados.

- Manutenção simplificada: Ao utilizar DTOs, é possível alterar a estrutura interna dos objetos de domínio sem afetar a interface dos DTOs. Isso facilita a manutenção do sistema, uma vez que as mudanças internas não afetam os componentes que dependem dos DTOs.

Um exemplo prático de uso do padrão DTO seria em um sistema de e-commerce, onde um DTO chamado ProdutoDTO poderia ser usado para transferir dados sobre um produto da camada de acesso a dados para a camada de apresentação. O DTO conteria os campos relevantes do produto, como nome, preço, descrição, etc., e seria responsável por transportar esses dados de forma eficiente entre as diferentes camadas do sistema.

``` java

public class Produto {    
    private Long id;    
    private String nome;    
    private double preco;    
    private String descricao;    
    private Date dataCadastro;  
      
    // Construtores, Getters e Setters omitidos no código
}
 
public class ProdutoDTO {   
    private String nome;    
    private double preco;    
    private String descricao;   
     
    // Construtires Getters e Setters omitidos no código
}

```

Para utilizar esse DTO, você pode criar uma instância do ProdutoDTO, preencher os campos com os dados do produto e passá-lo entre as camadas do sistema, como exemplo:

``` java

ProdutoDTO produtoDTO = new ProdutoDTO();
produtoDTO.setNome("Camiseta");
produtoDTO.setPreco(29.99);
produtoDTO.setDescricao("Uma camiseta confortável e estilosa.");
 
// Passar o produtoDTO para outra camada do sistema
// Até converte-lo, quando necessário, em um objeto do tipo Produto.
Produto produto = conversorToProduto(produtoDTO)

```

Assim, o DTO permite encapsular os dados do produto e transportá-los de forma eficiente entre as diferentes partes do sistema, mantendo a separação de responsabilidades e facilitando a manutenção do código.

# Analise da classe Usuario e porque criar DTO

Analisando os campos da classe Usuario podemos verificar que alguns deles não deveriam fazer parte de um corpo de requisição como também de um corpo de resposta.

``` java

public class Usuario implements Serializable {
    private Long id;    
    private String username;    
    private String password;    
    private Role role;    
    private LocalDateTime dataCriacao;    
    private LocalDateTime dataModificacao;    
    private String criadoPor;    
    private String modificadoPor;        
 
    // Construtores, Getters e Setters omitidos
}

```

Em se tratando de corpo de requisição, o campo role não deveria estar presente no JSON enviado pelo cliente. Isso porque, não é o cliente/usuário quem deve escolher qual perfil vai se cadastrar na API. Além disso, os campos de auditoria também não devem ser cadastrados pelo cliente.

Em se tratando de corpo de resposta, veja o resultado após uma consulta pelo id:

``` JSON

{    
    "id": 1,    
    "username": "[email protected]",    
    "password": "101010",    
    "role": "ROLE_ADMIN",    
    "dataCriacao": null,    
    "dataModificacao": null,    
    "criadoPor": null,    
    "modificadoPor": null
}

```

Alguns campos são desnecessários serem retornados para o cliente e, novamente, estamos falando sobre os campos de auditoria. O cliente não precisa e nem tem porque, ter qualquer motivo para visualizar os dados de auditoria. Esses valores são específicos para informações internas do gerenciamento da API.

Mas o mais grave nesta resposta é ter o campo password presente nela. Mesmo que o valor da senha estivesse criptografado, qual seria o motivo plausível para que a senha fosse retornada ao cliente? O campo de senha deve ficar restrito a API. Nunca deveria ser retornado como parte de uma resposta ao cliente.

Por conta desses motivos o ideal é ter DTOs para lidar tanto com os valores recebidos no corpo da requisição como também com os valores respondidos no corpo de resposta.

Outro fato importante a se destacar se refere a manipulação dos registros. Por exemplo, o perfil ROLE_ADMIN é uma instrução definida na API, para controlar dentro da API quem é administrador. Caso essa informação chegue ao cliente, ela não precisa chegar exatamente como ROLE_ADMIN. Apenas uma informação ADMIN é o bastante. Isso porque, o campo de resposta já é role e por isso, podemos evitar a redundancia. Mas não poderiamos manipular o valor ao retornar um objeto Usuario como corpo da resposta. Porém, poderiamos fazer a manipulação do valor caso tivessemos um DTO como resposta.

Em resumo, o padrão de projetos DTO é uma abordagem para transferir dados entre diferentes componentes de um sistema de forma eficiente, consistente e flexível, permitindo a separação de responsabilidades e melhorando a manutenção do sistema.