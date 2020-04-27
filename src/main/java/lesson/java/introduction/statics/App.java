package lesson.java.introduction.statics;

public class App {

    public static void main(String[] args) {
        StaticExample.a += 9;
        System.out.println("a = " + StaticExample.a);

        StaticExample se = new StaticExample();
        StaticExample se1 = new StaticExample();
        StaticExample se2 = new StaticExample();
        StaticExample se3 = new StaticExample();
        StaticExample se4 = new StaticExample();
        StaticExample se5 = new StaticExample();
        se.printSum(10);
        System.out.println("aa = " + se.a);

        StaticExampleB seb = new StaticExampleB();
        seb.printB(10);
        System.out.println("aaa = " + se.a);


        se5.a += 999;
        System.out.println("aaaaa = " + StaticExample.a);
    }
}
