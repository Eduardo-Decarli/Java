import entities.Circle;
import entities.Rectangle;
import entities.Shape;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();

        shapes.add(new Rectangle(3.0,2.0));
        shapes.add(new Circle(2.0));

        List<Circle> myCircle = new ArrayList<>();
        myCircle.add(new Circle(2.0));
        myCircle.add(new Circle(3.0));

        System.out.println("Total area: " + totalArea(shapes));
    }

    //Aqui, em vez de usar uma lista do tipo Shape, podemos colocar uma lista do tipo coringa que extends Shape, então ele aceitará qualquer classe que implementa Shape
    public static double totalArea(List<? extends Shape> list){
        double sum = 0;
        for(Shape s : list){
            sum += s.area();
        }
        return sum;
    }
}