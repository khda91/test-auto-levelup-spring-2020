package lesson.java.introduction.collections.list;

import java.util.*;

public class ListExample {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("mama");
        list.add("papa");
        list.add("vova");
        list.add("vova");
        list.add("vova");
        list.add("vova");
        list.add("vova");
        list.add("vova");
        list.add("vova");
        list.add("vova");
        list.add("vova");
        list.addAll(new TreeSet<>(Arrays.asList("\"vova\"", "vova", "vova")));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.remove("\"vova\"");
        list.remove(0);
        System.out.println(list);
    }
}
