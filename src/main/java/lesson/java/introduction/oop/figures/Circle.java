package lesson.java.introduction.oop.figures;

import lesson.java.introduction.oop.figures.base.Shape;

public class Circle extends Shape implements ISquare {

    double radius;

    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    public double square() {
        return Math.PI * radius * radius;
    }

    public void draw() {
        System.out.println("Circle (x || y)" + getX() + " || " + getY());
    }
}
