package entities;

public class Product {
    private String nome;
    private double price;

    public Product(String nome, double price) {
        this.nome = nome;
        this.price = price;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static boolean staticProductPredicate(Product p){
        return p.getPrice() >= 100.0;
    }

    public boolean noStaticProductPredicate(){
        return price >= 100.0;
    }

    public static void staticPriceUpdate(Product p){
        p.setPrice(p.getPrice() * 1.1);
    }

    public void noStaticPriceUpdate(){
        setPrice(getPrice() * 1.1);
    }

    public static String staticUpperCaseName(Product p){
        return p.getNome().toUpperCase();
    }

    public String noStaticUpperCaseName(){
        return getNome().toUpperCase();
    }
}
