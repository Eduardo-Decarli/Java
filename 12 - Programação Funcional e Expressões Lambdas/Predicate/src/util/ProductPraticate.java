package util;

import entities.Product;

import java.util.function.Predicate;
//Aqui criamos uma classe que implementa a interface funcional Predicate
public class ProductPraticate implements Predicate<Product> {

    //Aqui a classe nos força a implementar a função test
    @Override
    public boolean test(Product p) {
        return p.getPrice() >= 100.0;
    }
}
