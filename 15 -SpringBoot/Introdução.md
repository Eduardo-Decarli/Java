# O que é o SpringBoot

O Spring Framework é uma plataforma robusta que oferece suporte para o desenvolvimento de aplicações em Java, facilitando a construção de sistemas modulares, testáveis e manuteníveis. A seguir, vamos abordar dois princípios essenciais:

## Inversão de Controle (IoC)

Inversão de Controle (IoC) é um princípio de design onde o controle do fluxo do programa é passado para um framework ou container. No contexto do Spring, isso significa que a criação e gerenciamento de objetos (beans) é feito pelo próprio Spring, não pelo desenvolvedor.

O Spring usa um container IoC que instancia, configura e gerencia a interdependência entre objetos. Isso facilita a injeção de dependências, deixando o código mais limpo e flexível.

## Injeção de Dependências(DI)

A Injeção de Dependências (DI) é a forma pela qual o Spring implementa o IoC. Em vez de criar objetos diretamente dentro do código, o Spring injeta dependências nas classes através de construtores, métodos setters ou atributos, de forma automatizada.