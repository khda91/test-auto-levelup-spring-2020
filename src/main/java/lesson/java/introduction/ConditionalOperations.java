package lesson.java.introduction;

public class ConditionalOperations {

    public static void main(String[] args) {
        // if
        System.out.println("if");

        int a = 3 + 7;

        if (a == 10) {
            System.out.println("Winner");
        }

        System.out.println();
        System.out.println("=====");
        System.out.println();

        // ternary operator
        System.out.println("ternary operator");

        double x = 0.2;
        double y = 0.19999;

        double max = x > y ? x : y;

//        double max = 0;
//        if (x > y) {
//            max = x;
//        } else {
//            max = y;
//        }

        System.out.println(max);

        System.out.println();
        System.out.println("=====");
        System.out.println();
    }

    static void clickCheckbox(String checkbox) {
        if (checkbox.equals("selected")) {
            checkbox = "click";
        }
    }
}
