package lesson.java.introduction.statics;

public class StaticExample {

    static int a = 8;

    int sum = 10;

    static void countSumSquare() {
        StaticExample se = new StaticExample();
        System.out.println((se.sum * se.sum));
    }

    public void printSum(int b) {
        System.out.println("sum = " + (sum + b));
    }

    public void printA() {
        System.out.println(a);
    }

}
