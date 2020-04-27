package lesson.java.introduction.overload;

public class OverloadExample {

    public static void main(String[] args) {
        sum(1, 2);
        sum(3.1, 3.2);
        sum(1, 0.9999);
        sum(0.9999, 1);
    }

    static void sum(int a, int b) {
        System.out.println("int int");
        System.out.println(a + b);
    }

    static void sum(double a, double b) {
        System.out.println("double double");
        System.out.println(a + b);
    }

    static void sum(int a, double b) {
        System.out.println("int double");
        System.out.println(a + b);
    }

    static int sum(double a, int b) {
        System.out.println("double int = int");
        return (int) (a + b);
    }

    static double sum(double a, long b) {
        System.out.println("double int = double");
        return (a + b);
    }

}
