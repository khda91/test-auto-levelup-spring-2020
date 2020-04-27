package lesson.java.introduction.oop.figures;

public class Square extends Rectangle {

    public Square(double width) {
        super(width, width);
    }

    public void draw() {
        System.out.println("Square (x || y)" + getX() + " || " + getY());
    }

    @Override
    public double square() {
        return getWidth() * getWidth();
    }
}
