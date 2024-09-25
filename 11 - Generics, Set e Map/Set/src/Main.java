import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        /* HashSet */

        //Aqui declaramos um Set do tipo HashSet;
        Set<String> set = new HashSet<>();

        //Aqui adicionamos itens para a lista de Set
        set.add("TV");
        set.add("Notebook");
        set.add("Tablet");

        //Consulta se existe o elemento Notebook e retorna true/false
        System.out.println(set.contains("Notebook"));

        for (String p : set) {
            System.out.println(p);
        }

        System.out.println("----------------------");
        /* LinkedHashSet */

        //Aqui declaramos um Set do tipo HashSet;
        Set<String> hashSet = new HashSet<>();

        //Aqui adicionamos itens para a lista de Set
        hashSet.add("TV");
        hashSet.add("Notebook");
        hashSet.add("Tablet");

        //Remove um elemento de acordo com o predicado
        hashSet.removeIf(x -> x.length() >= 3);

        //Consulta se existe o elemento Notebook e retorna true/false
        System.out.println(set.contains("Notebook"));

        for (String p : hashSet) {
            System.out.println(p);
        }

        System.out.println("---------------------");

        /* TreeSet */

        Set<Integer> a = new TreeSet<>(Arrays.asList(0,2,4,5,6,8,10));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5,6,7,8,9,10));

        //União entre TreeSets ignorando hash existentes
        Set<Integer> c = new TreeSet<>(a);
        c.addAll(b);
        System.out.println(c);

        //Busca por parametros duplicados
        Set<Integer> d = new TreeSet<>(a);
        d.retainAll(b);
        System.out.println(d);
    }
}