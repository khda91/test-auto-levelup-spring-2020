package lesson.java.introduction.oop.figures.base;

public abstract class Shape {

    protected double x;
    double y;

    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract void draw();

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
