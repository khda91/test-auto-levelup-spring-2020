package lesson.java.introduction.loops;

public class WhileLoop {

    public static void main(String[] args) {
        // Inf loop
//        while (true) {
//            System.out.println("Infinity loop");
//
//        }

        System.out.println("===");
        int count = 10;
        while (count < 10) {
            System.out.println(count);
            count++;
        }

        System.out.println("===");
        System.out.println("do-while");
        count = 10;
        do {
            System.out.println(count);
            count++;
        } while (count < 10);

    }
}
