package lesson.java.introduction.oop.figures;

public class Recircle {

    Rectangle rectangle;
    Circle circle;

    public Recircle(Rectangle rectangle) {
        this.rectangle = rectangle;
        circle = new Circle(rectangle.getX(), rectangle.getY(), 0.0);
        circle.radius = rectangle.getWidth() / rectangle.getHeight() * 10;
    }
}
