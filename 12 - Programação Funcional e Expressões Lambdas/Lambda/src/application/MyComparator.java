package application;

import entities.Product;

import java.util.Comparator;

//O Comparator permite que você crie a sua própria regra de comparação,
// dizendo ao Java como um objeto deve ser comparado com outro.
public class MyComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        // a função compareTo() é usada para comparar o próprio objeto com outro objeto do mesmo tipo
        //Ele retorna 3 valores, retorna negativo se o objeto de comparação for menor, retorna zero se são iguais e positivo se o objeto de comparação é maior
        return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
    }
}
