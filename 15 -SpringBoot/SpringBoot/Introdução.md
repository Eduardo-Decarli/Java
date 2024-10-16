# O que é o Spring Framework

O Spring Framework é uma plataforma robusta que oferece suporte para o desenvolvimento de aplicações em Java, facilitando a construção de sistemas modulares, testáveis e manuteníveis. A seguir, vamos abordar dois princípios essenciais:

## Inversão de Controle (IoC)

Inversão de Controle (IoC) é um princípio de design onde o controle do fluxo do programa é passado para um framework ou container. No contexto do Spring, isso significa que a criação e gerenciamento de objetos (beans) é feito pelo próprio Spring, não pelo desenvolvedor.

O Spring usa um container IoC que instancia, configura e gerencia a interdependência entre objetos. Isso facilita a injeção de dependências, deixando o código mais limpo e flexível.

## Injeção de Dependências(DI)

A Injeção de Dependências (DI) é a forma pela qual o Spring implementa o IoC. Em vez de criar objetos diretamente dentro do código, o Spring injeta dependências nas classes através de construtores, métodos setters ou atributos, de forma automatizada.

# Configurações do Spring

O Spring pode ser configurado de duas maneiras

- XML Configuration: A configuração de beans e dependências pode ser feita via arquivo XML (Embora se tornou uma metodologia mais antiga)

- Anotations (Java Config): Anotações como **@Component, @Service, @Repository, @Controller** e **@Autowired** são amplamente usadas para configurar e gerenciar beans de forma mais moderna. Essa abordagem é mais moderna e é a mais usada no Spring Boot. Em vez de usar XML, você usa anotações nas suas classes para configurar o comportamento do Spring. A configuração baseada em anotações é geralmente mais concisa, fácil de manter e oferece mais controle em tempo de compilação.

## Classe de Configurações Manuais

Embora o Spring gerencie automaticamente muitos beans via anotações como @Service e @Repository, às vezes você pode querer definir beans manualmente em uma classe de configuração. Para isso, usamos @Configuration e @Bean.

``` java

@Configuration
public class AppConfig {

    @Bean
    public BookRepository bookRepository() {
        return new BookRepository();  // Criação manual do bean
    }

    @Bean
    public BookService bookService(BookRepository bookRepository) {
        return new BookService(bookRepository);  // Injeção de dependência manual
    }
}

```

# Spring Boot

O Spring Boot é uma extensão do Spring Framework que visa facilitar o desenvolvimento de aplicações, fornecendo: 

- Configuração automática (Auto-Configuration): Define automaticamente as configurações padrão com base nas dependências do projeto.

- Servidor embutido: Possibilita rodar a aplicação em servidores como Tomcat ou Jetty sem necessidade de configuração externa.

- Starter Projects: Conjuntos predefinidos de dependências para facilitar o início de projetos com diferentes tecnologias (como web, dados, segurança, etc.).

- Produção rápida: Gera aplicações prontas para deploy rapidamente.

## Configuração Inicial do Spring Boot

O Spring Boot simplifica a configuração de projetos Spring, eliminando a necessidade de muitas configurações manuais e fornecendo um ambiente pronto para uso com convenções bem definidas. Aqui vamos explorar como criar um projeto Spring Boot.

### Criando um Projeto Spring Boot

O método mais simples para criar um projeto Spring Boot é utilizando o Spring Initializr. Ele gera automaticamente o esqueleto de um projeto com a estrutura básica e dependências configuradas.

#### Criação através do Spring Initializr

- Project: Maven ou Gradle (use Maven, pois é o mais comum).

- Language: Java.

- Spring Boot Version: Use a versão estável mais recente.

- Group: Defina o nome do grupo (geralmente algo como com.seuprojeto).

- Artifact: O nome do projeto.

- Name: Nome do projeto.

- Description: Descrição opcional.

- Package Name: Nome do pacote principal (geralmente igual ao Group).

- Packaging: JAR (geralmente).

- Java Version: Use a versão mais recente (17 ou superior).

#### Adicionar Dependências

Adicione dependências conforme sua necessidade. Por exemplo:

- Spring Web: Para criar uma API ou aplicação web.

- Spring Data JPA: Para trabalhar com bancos de dados relacionais.

- Spring Security: Para lidar com autenticação e autorização.

- H2 Database: Um banco de dados em memória útil para testes.

### Estrutura padrão de como é formado o SpringBoot 

``` scss

src/
├── main/
│   ├── java/
│   │   └── com/example/demo/  (pacote base)
│   │       └── DemoApplication.java  (classe principal)
│   └── resources/
│       ├── application.properties  (arquivo de configuração)
│       └── static/  (arquivos estáticos como HTML, CSS, JS)
├── test/
│   └── java/
│       └── com/example/demo/  (testes unitários)
pom.xml  (arquivo de configuração do Maven)

```

## Principais Arquiteturas do SpringBoot

O Spring Boot é bastante flexível e suporta várias arquiteturas de projetos. Aqui estão algumas das arquiteturas mais comuns utilizadas com Spring Boot, junto com uma breve descrição e exemplos de quando usá-las.

### Arquitetura em Camadas

Uma das abordagens mais tradicionais. A aplicação é dividida em camadas, onde cada camada tem uma responsabilidade específica. As camadas típicas são:

- Apresentação: Responsável pela interface com o usuário (controladores).

- Serviços: Contém a lógica de negócios (serviços).

- Persistência:  Interage com o banco de dados (repositórios).

- Modelo: Define as entidades e suas relações

Ideal para aplicações pequenas a médias, onde a separação clara de responsabilidades facilita a manutenção.

``` txt

├── com.example.demo
    ├── controller
    ├── service
    ├── repository
    ├── model

```

### Arquitetura Baseada em Microserviços

A aplicação é dividida em serviços independentes que se comunicam entre si via APIs. Cada microserviço é responsável por uma funcionalidade específica e pode ser desenvolvido, implantado e escalado de forma independente.

Ideal para aplicações grandes e complexas que precisam de escalabilidade e resiliência, permitindo que equipes trabalhem em diferentes serviços simultaneamente.

``` txt

├── user-service
├── book-service
├── loan-service
├── api-gateway

```