package lesson.java.introduction.oop.figures;

import lesson.java.introduction.oop.figures.base.Shape;

public class Triangle extends Shape implements ISquare {

    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x, double y, double x2, double y2, double x3, double y3) {
        super(x, y);
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }


    public double square() {
        return 0;
    }

    public void draw() {

    }
}
