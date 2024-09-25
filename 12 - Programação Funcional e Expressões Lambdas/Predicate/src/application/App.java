package application;

import entities.Product;
import services.ProductService;
import util.ProductConsumer;
import util.ProductFunction;
import util.ProductPraticate;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();

        /* PREDICATE */

        list.add(new Product("Tv", 900.0));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.00));
        list.add(new Product("HD Case", 80.90));

        //Usando Lambda
        list.removeIf(p -> p.getPrice() >= 100.0);

        //Usando a interface Predicate
        list.removeIf(new ProductPraticate());

        //Usando Métodos Estáticos
        list.removeIf(Product::staticProductPredicate);

        //Usando métodos não estáticos
        list.removeIf(Product::noStaticProductPredicate);

        //Lambda Declarada
        Predicate<Product> pred = p -> p.getPrice() >= 100.0;
        list.removeIf(pred);

        for(Product p : list){
            System.out.println(p);
        }

        /* CONSUMER */

        //Usando Lambda
        //para usar o forEach() é necessário um consumer, ele irá percorrer a lista e aplicar a lógica
        list.forEach((Product p) -> p.setPrice(p.getPrice() * 1.1));

        //Usando a interface Consumer
        list.forEach(new ProductConsumer());

        //Usando métodos Estáticos
        list.forEach(Product::staticPriceUpdate);

        //Usando métodos não estáticos
        list.forEach(Product::noStaticPriceUpdate);

        //Usando Lambda Declarada
        Consumer<Product> pred2 = (Product p) -> p.setPrice(p.getPrice() * 1.1);
        list.forEach(pred2);

        list.forEach(System.out::println);

        /* FUNCTION */

        //Usando Lambda
        List<String> names1 = list.stream().map(p -> p.getNome().toUpperCase()).collect(Collectors.toList());

        //Usando a interface Function
        List<String> names2 = list.stream().map(new ProductFunction()).collect(Collectors.toList());

        //Usando métodos estáticos
        List<String> names3 = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList());

        //Usando métodos não estáticos
        List<String> names4 = list.stream().map(Product::noStaticUpperCaseName).collect(Collectors.toList());

        //Usando lambda declarada
        Function<Product, String> lambdaFunction = (Product p) -> p.getNome().toUpperCase();
        List<String> names5 = list.stream().map(lambdaFunction).collect(Collectors.toList());

        //Criando funções que recebem Funções
        ProductService ps = new ProductService();

        double sum = ps.filteredSum(list, p -> p.getNome().charAt(0) == 'T');

    }
}