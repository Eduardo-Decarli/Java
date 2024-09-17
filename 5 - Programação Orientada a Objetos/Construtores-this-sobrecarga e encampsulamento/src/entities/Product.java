package entities;

public class Product {
    //Atributos
    //Um ponto importante do encapsulamento é tornar os atributos privados
    //Dessa forma não se consegue esplicitamente alterar eles por meio de outras classes
    //Também privamos o acesso deles, onde podem ser acessados apenas por meio dos métodos de acesso get e set
    //Existem 3 modificadores de acesso, public(Importa para todas as classes), private(Acessado apenas pela propria classe) e protected(Só pode ser acessado pelo mesmo pacote, bem como em subclasses de pacotes diferentes)
    private String name;
    private double price;
    private int quantity;

    //Aqui definimos um construtor, onde os atributos terão que ser obrigatoriamente passados para ele no momento da instanciação
    public Product(String name, double price, int quantity){
        //O uso da palavra This faz referencia ao próprio objeto
        // Aqui this.name não se refere ao name da função, mas sim ao name da classe
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    //Overide é quando se tem uma sobrecarga de um método, isso significa usar o mesmo nome de um método já existente, para um novo método que faz funções diferentes
    //Agora nós temos dois métodos construtores, onde um tem quantity e outro não, um solicita a definição obrigatória de quantity, e outro começa com zero
    //Agora pode-se instanciar um construtor com e sem a propriedade quantity, esse uso de sobrecarga se aplica a qualquer função
    public Product(String name, double price){
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    /* Encapsulamento */
    //Aqui nós privamos os atributos de cada classe para serem acessadas apenas por meio das respectivas funções de acesso
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //Métodos
    public double totalValueInStock() {
        return price * quantity;
    }

    public void addProducts(int quantity) {
        this.quantity += quantity;
    }

    public void removeProducts(int quantity) {
        this.quantity -= quantity;
    }

    //Sobre escrita da função toString do objeto Object
    public String toString() {
        return name + ", $ " + String.format("%.2f", price) + ", " + quantity + " units, Total: $ " + String.format("%.2f", totalValueInStock());
    }
}