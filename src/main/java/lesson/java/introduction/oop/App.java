package lesson.java.introduction.oop;

import lesson.java.introduction.oop.figures.Circle;
import lesson.java.introduction.oop.figures.ISquare;
import lesson.java.introduction.oop.figures.Rectangle;
import lesson.java.introduction.oop.figures.Square;
import lesson.java.introduction.oop.figures.base.Shape;

public class App {

    public static void main(String[] args) {
        Circle circle = new Circle(1.0, 1.0, 2.0);
        Rectangle rectangle = new Rectangle(2.5, 2.5, 3, 4);

        ISquare[] squares = {circle, rectangle};
        for (ISquare square : squares) {
            System.out.println(square.square());
        }

        System.out.println(Circle.III);
        System.out.println(Rectangle.III);
        System.out.println(Square.III);

    }
}
