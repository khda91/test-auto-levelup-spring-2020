package lesson.java.introduction.exceptions;

public class RuntimeExceptionsExample {

    public static void main(String[] args) {
        divide(8, 4);
        divide(8, 1/5);

        String str = null;
        if (str != null) {
            str.startsWith("h");
        }
    }

    public static void divide(int a, int b) {
        if (b != 0) {
            System.out.println("result: " + (a / b));
        }
    }
}
