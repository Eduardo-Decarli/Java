# Pacotes que Formam o Java

O java é divido em hierarquia e organizado em pacotes, cada pacote do java, carrega com sigo uma gama de classes com funcionalidades primárias para o java, os pacotes padrões do java não precisam explicitamente serem evocados no momento de usar um atributo, apenas importados no código.

## java.lang

O pacote **java.lang** é parte do núcleo da linguagem Java e contém classes fundamentais para a programação em Java. Ele é automaticamente importado em todos os programas Java, ou seja, você não precisa importar explicitamente esse pacote para usar as classes que ele contém.

### Classes Principais do java.lang

- **Object:** É a classe raiz de todas as classes em Java. Todas as classes herdam diretamente ou indiretamente desta classe. Ela fornece métodos como equals(), hashCode(), toString(), entre outros.

- **String:** Classe que representa cadeias de caracteres. Como as strings são usadas com frequência, a classe String tem funcionalidades poderosas para manipulação de texto.

- **Math:** Fornece métodos matemáticos como **sin()**, **cos()**, **sqrt()**, **pow()**, entre outros, para realizar operações matemáticas comuns.

- **Integer, Double, Float, Boolean, Long:** Classes empacotadoras (wrappers class) para tipos primitivos, permitindo que esses tipos sejam tratados como objetos.

- **Thread:** Classe para criar e controlar threads (fluxos de execução) em Java.

- **System:** Contém métodos úteis para acessar recursos do sistema, como entrada e saída padrão (System.out, System.in) e métodos para manipulação de propriedades do sistema e gerenciamento de memória.

- **Exception, RuntimeException, Error:** Classes relacionadas ao tratamento de exceções e erros no Java.

Essas classes são essenciais para a maioria dos programas Java, pois oferecem funcionalidades que são frequentemente necessárias para a maioria das aplicações.

## java.util

Nesse pacote, possui classes e interfaces que ajudam a trabalhar com grupos e listas de objetos (coleções) e oferecem diversas operações, como adição, remoção e busca de elementos, as classes e interfaces são: 

- **List:** Interface que representa uma lista de elementos, onde a ordem de inserção é mantida. Implementações comuns:

    - **ArrayList:** Lista baseada em array, muito eficiente para acessos rápidos.
    - **LinkedList:** Lista encadeada, melhor para operações de inserção e remoção.

- **Set:** Interface que representa um conjunto de elementos, sem duplicatas. Implementações comuns:
    - **HashSet:** Conjunto que não garante a ordem dos elementos.
    - **TreeSet:** Conjunto ordenado, baseado na ordenação natural ou em um comparador.

- **Map:** Interface que mapeia chaves a valores. Implementações comuns:

    - **HashMap:** Estrutura de mapa baseada em tabela de dispersão (hash), que permite busca rápida de elementos pela chave.
    - **TreeMap:** Mapa ordenado, com as chaves dispostas em ordem crescente ou de acordo com um comparador

- **Queue:** Interface que representa uma fila de elementos, seguindo a regra FIFO (First-In-First-Out). Implementação comum:
    - **PriorityQueue:** Fila de prioridade que ordena os elementos conforme sua prioridade.

## java.io

O pacote **java.io** fornece classes para realizar operações de **entrada e saída (I/O)** em Java. Ele é utilizado para ler e escrever dados de diferentes fontes, como arquivos, fluxos de dados (streams), e dispositivos externos. A abordagem principal do pacote é baseada no conceito de streams, que abstraem a entrada e saída de dados como uma sequência contínua de bytes ou caracteres. Ele possui as classes:

- **File:** Representa um arquivo ou diretório no sistema de arquivos. Você pode usá-la para verificar se um arquivo ou diretório existe, criar, renomear ou deletar arquivos, e obter informações como o tamanho ou permissões.

- **FileReader:** Usado para ler dados de arquivos de texto, convertendo diretamente bytes em caracteres de forma eficiente

- **FileWriter:** Usado para gravar caracteres em um arquivo de texto

- **BufferedReader:** Lê texto de um arquivo de maneira eficiente, armazenando em buffer. Isso melhora o desempenho na leitura de grandes volumes de textos. 

- **BufferedWriter:** Ele escreve textos em um arquivo de maneira eficiente, armazenando em buffer os dados antes de gravar.

### Interfaces principais do java.io

- **Serializable:** Marca uma classe como serializavel, ou seja, indica que o objeto dessa classe pode ser convertido em uma sequencia de bytes e restaurados(desserializados). É uma interface de marcação, ou seja, uma interface vazia.

## java.net

O pacote java.net é utilizado para operações de rede em Java, permitindo que você crie programas que se comuniquem via protocolos de rede, como **TCP/IP** e **HTTP**. Ele oferece classes e interfaces para implementar clientes e servidores de rede, além de manipular endereços de rede e URLs.

- **url:** Representa um endereço da **Web**, Com essa classe, pode-se acessar recursos pela internet ou rede local, como arquivos ou páginas da web.

- **URLConnection:** Representa uma conexão com o recurso especificado por uma **URL**, Permite ler e gravar dados de/para um servidor. É uma classe pai da classe **HttpURLConnection**, que é usada para comunicações **HTTP**. Essa classe também é usada para operações como enviar dados **POST** e **GET** para servidores web.

- **HttpURLConnection:** Extenção da **URLConnection**, suporta métodos HTTP como **GET**, **POST**, **PUT**, **DELETE**, entre outros. Possui métodos para definir o tipo da requisição e para obter o código de respostas HTTP.

## java.sql

O pacote **java.sql** faz parte da **API JDBC (Java Database Connectivity)** e fornece classes e interfaces que permitem que programas Java se conectem a bancos de dados, enviem consultas SQL, recuperem dados e manipulem informações. Esse pacote é crucial para a integração de aplicações Java com bancos de dados relacionais.

- **Connection:** Representa uma conexão com um banco de dados. Ela é usada para estabelecer e gerenciar a comunicação entre a aplicação Java e o banco de dados.

- **Statement:** Usada para executar consultas SQL simples e comandos no banco de dados. Não é muito eficiente para consultas repetidas, pois compila o SQL toda vez que é executado.

- **PreparedStatement:** Um tipo mais eficiente de Statement, usado para executar consultas SQL pré-compiladas. Ele permite a inserção de parâmetros dinâmicos em uma consulta, o que ajuda a evitar injeção de SQL.

- **ResultSet:** Representa os resultados de uma consulta SQL (normalmente SELECT). Ele permite percorrer os dados retornados linha por linha e extrair os valores das colunas.

- **DriverManager:** Gerencia os drivers JDBC disponíveis e facilita a criação de conexões com o banco de dados.

- **SQLException:** Representa exceções relacionadas a erros de banco de dados. É lançada em várias operações JDBC para indicar problemas como falha de conexão, consulta malformada, etc.

## java.time

O pacote java.time foi introduzido no Java 8 para substituir as classes de manipulação de datas e horas das versões anteriores, oferecendo uma API mais moderna e amigável. Ele segue conceitos inspirados pela biblioteca Joda-Time e permite o uso de classes imutáveis e thread-safe para trabalhar com datas, horários e períodos.

- **LocalDate:** Representa uma data (dia, mês e ano) sem informações de horário ou fuso horário. É útil quando você deseja trabalhar com datas sem se preocupar com o tempo exato.

- **LocalTime:** Representa apenas um horário (hora, minuto, segundo e nanossegundo), sem qualquer informação de data ou fuso horário

- **LocalDateTime:** Combina LocalDate e LocalTime, representando uma data e um horário sem informações de fuso horário.

- **ZonedDateTime:** Representa uma data e horário com informações de fuso horário (timezone). É útil quando você precisa lidar com eventos em diferentes regiões do mundo.

- **Duration:** Representa uma duração de tempo em horas, minutos, segundos e nanossegundos. É útil para medir intervalos de tempo.

- **Instant:** Representa um instante específico no tempo, contido como o número de segundos (ou nanossegundos) desde o Epoch (1970-01-01T00:00:00Z). Ele é útil para marcações temporais (timestamps).

### Interfaces principais do java.time

- **Temporal:** Interface básica para objetos que possuem uma dimensão temporal, como LocalDate, LocalTime e ZonedDateTime. Ela define métodos para manipulação de valores temporais.

- **ChronoUnit:** Enumeração que define unidades de tempo, como ChronoUnit.DAYS, ChronoUnit.MONTHS, ChronoUnit.YEARS. É usada para calcular ou medir o tempo entre objetos temporais.
