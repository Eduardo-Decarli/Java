# O que é o Spring Security?

O Spring Security é um framework que adiciona camadas de autenticação e autorização a aplicações Spring Boot. Ele facilita a proteção de endpoints de API, fornecendo mecanismos de controle de acesso, como permissões e roles de usuários.

Principais funcionalidades:

- **Autenticação** (verificar se o usuário é quem diz ser).

- **Autorização** (definir o que o usuário autenticado pode fazer).

- **Integração** com diversos métodos de autenticação (formulário, OAuth, JWT, etc.).

## O que é JWT (JSON Web Token)?

O JWT (JSON Web Token) é um padrão aberto usado para compartilhar informações entre um cliente e um servidor de forma segura. Ele é usado principalmente em sistemas de autenticação como uma alternativa aos tradicionais mecanismos de sessão.

O JWT é dividido em 3 partes:

- Header: Define o tipo de token (JWT) e o algoritmo de assinatura (por exemplo, HS256).

- Payload: Contém as informações ou “claims” (por exemplo, userId, roles).

- Signature: Uma assinatura que valida a integridade do token.

# Fluxo de Trabalho do JWT

Em uma aplicação Spring Security, o JWT é usado para autenticar os usuários sem a necessidade de manter sessões no servidor. O fluxo básico de autenticação JWT é:

1. O usuário faz login e envia suas credenciais.

2. O servidor valida as credenciais e, se forem válidas, gera um JWT.

3. O JWT é enviado de volta ao cliente, que o armazena (geralmente no localStorage ou sessionStorage).

4. O cliente envia o JWT em cada requisição subsequente no cabeçalho Authorization.

5. O servidor valida o JWT e, se válido, permite o acesso aos recursos protegidos.

# Configurações

- Dependências do Spring Security e JWT

``` xml

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.11.2</version>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.11.2</version>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId> <!-- para compatibilidade com jackson -->
    <version>0.11.2</version>
</dependency>

```

- Configurando o Spring Security

Crie uma classe de configuração que estenda WebSecurityConfigurerAdapter para customizar a segurança da aplicação.

``` java

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/login", "/register").permitAll() // Endpoints públicos
            .anyRequest().authenticated(); // Outros endpoints precisam de autenticação
    }
}

```