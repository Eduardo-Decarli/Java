# Classe Math em Java

A classe `Math` em Java faz parte do pacote `java.lang` e fornece métodos para realizar operações matemáticas comuns, como cálculo de potências, raízes quadradas, trigonometria, logaritmos e arredondamento.

## Características da Classe `Math`

- Todos os métodos da classe `Math` são **estáticos**, o que significa que podem ser chamados diretamente sem a necessidade de instanciar um objeto da classe `Math`.
- A classe `Math` lida com os tipos de dados `double` e `float` para a maioria dos seus métodos.
- Algumas constantes matemáticas importantes, como **PI** e **E**, são disponibilizadas diretamente.

### Exemplo de uso:

```java

double resultado = Math.sqrt(25); // Calcula a raiz quadrada de 25
System.out.println(Math.PI); // Retorna o PI 3.141592653589793
double potencia = Math.pow(2, 3); // Retoran a potencia entre 2 elevado a 3
int absoluto = Math.abs(-10); // Retorna o valor absoluto do numero ou variavel
int maior = Math.max(10, 20); // Retorna o maior numero entre os valores
int menor = Math.min(10, 20); // Retorna o menor numero entre eles
double arredondado = Math.round(5.7); // Arredonda para o numero mais próximo
double paraCima = Math.ceil(5.3);     // Arredonda para cima
double paraBaixo = Math.floor(5.9);   // Arredonda para baixo
double aleatorio = Math.random(); // Retorna um numero alteatório entre 0.0 e 1.0
int aleatorioEntre1e10 = (int) (Math.random() * 10) + 1; // Aleatoriza um valor entre 1 e 10

```