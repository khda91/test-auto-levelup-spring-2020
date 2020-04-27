package lesson.java.introduction.constructor;

public class App {

    public static void main(String[] args) {
//        Point point1 = new Point();
//        System.out.println("point1 : " + point1.getX() + " || " + point1.getY());
//
//
//        Point point2 = new Point();
//        point2.setX(4.3);
//        point2.setY(4.3);
//        System.out.println("point2 : " + point2.getX() + " || " + point2.getY());
//
//        Point point3 = new Point(5.0, 1.3);
//        System.out.println("point3 : " + point3.getX() + " || " + point3.getY());

        // передача параметров
        Point newPoint = new Point(2.0, 2.0);
        changePoint(newPoint);
        System.out.println("new point : " + newPoint.getX() + " || " + newPoint.getY());

        changePointA(newPoint);
        System.out.println("new point : " + newPoint.getX() + " || " + newPoint.getY());

        Point a = newPoint;
        Point b = a;
        Point c = newPoint;

        c.setY(8.9);
        b.setX(-0.01);
        System.out.println("new point : " + newPoint.getX() + " || " + newPoint.getY());
    }

    static void changePoint(Point point) {
        point.setX(5.0);
    }

    static void changePointA(Point point) {
        Point p = new Point(point.getX(), point.getY());
        p.setY(6.0);
        System.out.println("p point : " + p.getX() + " || " + p.getY());
    }
}
