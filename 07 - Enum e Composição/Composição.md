# Composição

O conceito de composição em programação orientada a objetos refere-se a um tipo de relacionamento entre classes em que uma classe contém referências a uma ou mais instâncias de outras classes, formando um relacionamento de "tem um" (HAS-A). Na composição, uma classe contém outra classe como parte de sua estrutura, e as partes dependem totalmente do todo. Em outras palavras, a classe "composta" (o todo) gerencia o ciclo de vida das classes "componentes" (as partes).

Se o objeto que representa o todo for destruído, todas as suas partes também são destruídas, o que caracteriza um relacionamento de forte dependência entre as classes.

## Caracteristicas da Composição

- Relação de Forte Dependência: Os objetos componentes não fazem sentido fora do contexto do objeto principal. Quando o objeto principal (contêiner) é destruído, seus componentes também são destruídos.

- Ciclo de Vida Gerenciado: O objeto composto controla o ciclo de vida dos objetos que ele contém. Ele cria, usa e destrói esses objetos quando necessário.

- "Parte-Todo": A composição é vista como um relacionamento de "parte-todo". Um exemplo clássico é uma classe Carro que contém componentes como Motor, Rodas, Portas, etc.

## Exemplo de Composição

``` java

class Motor {
    private String tipo;
    
    public Motor(String tipo) {
        this.tipo = tipo;
    }
    
    public String getTipo() {
        return tipo;
    }
}

class Roda {
    private String marca;
    
    public Roda(String marca) {
        this.marca = marca;
    }
    
    public String getMarca() {
        return marca;
    }
}

class Carro {
    private Motor motor;
    private Roda[] rodas;
    
    public Carro(String tipoMotor, String marcaRoda) {
        this.motor = new Motor(tipoMotor); // O carro cria o motor
        this.rodas = new Roda[] {
            new Roda(marcaRoda),
            new Roda(marcaRoda),
            new Roda(marcaRoda),
            new Roda(marcaRoda)
        }; // O carro cria as rodas
    }
    
    public void detalhesCarro() {
        System.out.println("Carro com motor: " + motor.getTipo());
        for (int i = 0; i < rodas.length; i++) {
            System.out.println("Roda " + (i+1) + " marca: " + rodas[i].getMarca());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Carro meuCarro = new Carro("V8", "Michelin");
        meuCarro.detalhesCarro();
    }
}

```