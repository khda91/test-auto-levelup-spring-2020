package lesson.java.introduction.oop.figures;

import lesson.java.introduction.oop.figures.base.Shape;

public class Rectangle extends Shape implements ISquare {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this(0.0, 0.0, width, height);
    }

    public Rectangle(double x, double y, double width, double height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public void draw() {
        System.out.println("Rectangle (x || y)" + getX() + " || " + getY());
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double square() {
        return width * height;
    }
}
