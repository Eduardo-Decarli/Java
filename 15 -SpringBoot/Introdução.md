# O que é o SpringBoot

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

## Anotações Comuns do Spring

- **@Component**: Marca uma classe como um bean gerenciado pelo Spring. A classe será registrada no container IoC.

- **@Service**: Semelhante ao **@Component**, mas semanticamente indica que a classe está no nível de serviço.

- **@Repository**: Indica que a classe é responsável pelo acesso a dados (DAO/repositório).

- **@Controller**: Marca uma classe como um controlador para lidar com requisições HTTP (em uma aplicação web).

- **@Autowired**: Indica que uma dependência deve ser injetada automaticamente pelo Spring

- **@Configuration**: Indica que uma classe contém métodos que definem beans. Essa classe é usada para configurar o contexto da aplicação sem precisar de XML.

- **@Bean**: É usado dentro de classes @Configuration para declarar beans manualmente