package lesson.java.introduction.generics;

import lesson.java.introduction.collections.Person;

import java.util.ArrayList;

public class JavaOnePointFive {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList();
        list.add("jjhhds");
        list.add("asdasda");
        list.add("ass");
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4.7);
//        list.add(4.883823802796);
//        list.add(3.1415);
//        list.add(new Person("mmmj", 2));
        System.out.println(list);
        System.out.println();

        for (Object o : list) {
            if (o instanceof String) {
                String str = (String) o;
                System.out.println(str);
            }
        }
    }
}
