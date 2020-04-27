package lesson.java.introduction.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExceptionExample {

    public static void main(String[] args) {
        printer();

        try {
            printerThrows();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void printer() {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("out1.txt"));
            for (int i = 0; i < 1000; i++) {
                out.println("Some string");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
//        try {
//            out = new PrintWriter(new FileWriter("out.txt"));
//            for (int i = 0; i < 1000; i++) {
//                out.println("Some string");
//            }
//        } catch (IOException e) {
//            System.err.println("Caught IOException: "
//                    + e.getMessage());
//        } finally {
//            if (out != null) {
//                System.out.println("Closing PrintWriter");
//                out.close();
//            } else {
//                System.out.println("PrintWriter not open");
//            }
//        }
    }

    static void printerThrows() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter("out1.txt"));
        for (int i = 0; i < 1000; i++) {
            out.println("Some string");
        }
    }
}
