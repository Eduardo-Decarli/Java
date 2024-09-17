package entities;

//Aqui definimos uma classe, uma classe serve como modelo para mais de um objeto
//Classes podem ter atributos(propriedades) e métodos(Funções)
public class Triangle {
    public double a;
    public double b;
    public double c;

    //Aqui definimos um método nativo da classe Triangle, onde apenas objetos do tipo triangle podem utilizar ele
    public double area(){
        double p = (a + b + c) / 2;
        double result = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return result;
    }

    //classe toString em Java não é uma classe propriamente dita, mas sim um método que pertence à classe Object, a classe base de todas as classes em Java. O método toString é usado para retornar uma representação em formato de string de um objeto.
    //A classe toString pode ser feita o override dela atravez de uma reescrita do seu código
    public String toString(){
        return "O triangulo tem os lados com valor: " + this.a + ", " + this.b + ", " + this.c;
    }
}
/* O uso de classes em um código, influencia em dois fatores: O reaproveitamento de código e a delegação de responsabilidade devida as funções das próprias classes */
