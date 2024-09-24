package services;

import java.util.ArrayList;
import java.util.List;

// A classe PrintService é genérica. O <T> indica que ela pode trabalhar com qualquer tipo de dado.
public class PrintService<T> {

    // O atributo list é uma lista do tipo T, que pode ser qualquer tipo de dado (Integer, String, etc.)
    private List<T> list = new ArrayList<>();

    // O método addValue adiciona um valor do tipo T na lista.
    // Isso significa que a lista pode armazenar qualquer tipo definido no momento da criação da instância da classe.
    public void addValue(T value) {
        list.add(value);
    }

    // O método first retorna o primeiro elemento da lista do tipo T.
    // Se a lista estiver vazia, ele lança uma exceção, pois não há valores a serem retornados.
    public T first() {
        if (list.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return list.get(0);
    }

    // O método print imprime todos os elementos da lista em um formato de array [element1, element2, ...].
    // A lista é do tipo T, então ela pode conter qualquer tipo de objeto, conforme definido ao criar a instância.
    public void print() {
        System.out.print("[");
        if (!list.isEmpty()) {
            System.out.print(list.get(0));
        }
        // Para os outros elementos da lista, imprime uma vírgula antes do próximo valor.
        for (int i = 1; i < list.size(); i++) {
            System.out.print(", " + list.get(i));
        }
        System.out.println("]");
    }
}
