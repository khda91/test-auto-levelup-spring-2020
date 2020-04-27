package lesson.java.introduction.collections.set;

import lesson.java.introduction.collections.Person;
import lesson.java.introduction.collections.PersonComparator;

import java.util.*;

public class SetExample {

    public static void main(String[] args) {
        System.out.println("+++++++++++++++++++++");
        System.out.println("====== HashSet =======");
        hashSetExample();
        System.out.println("+++++++++++++++++++++");
        System.out.println();

        System.out.println("+++++++++++++++++++++");
        System.out.println("====== LinkedSet =======");
        linkedSetExample();
        System.out.println("+++++++++++++++++++++");
        System.out.println();

        System.out.println("+++++++++++++++++++++");
        System.out.println("====== TreeSet =======");
        treeSetExample();
        System.out.println("+++++++++++++++++++++");
        System.out.println();

        System.out.println("+++++++++++++++++++++");
        System.out.println("====== TreePersonSet =======");
        treeSetPersonExample();
        System.out.println("+++++++++++++++++++++");

        System.out.println("+++++++++++++++++++++");
        System.out.println("====== TreeSetPersonComparator =======");
        treeSetPersonWithoutComparableExample();
        System.out.println("+++++++++++++++++++++");

        System.out.println("+++++++++++++++++++++");
        System.out.println("====== HashSetCustomObjects =======");
        hashSetCustomObjects();
        System.out.println("+++++++++++++++++++++");
    }

    static void hashSetExample() {
//        Set<String> set = new HashSet<>();
        HashSet<String> set = new HashSet<>();
        set.add("mama");
        set.add("papa");
        set.add("vova");
        set.add("jora");
        set.addAll(Arrays.asList("ksusha", "kesha", "umka"));

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println();

        set.remove("vova");
        set.remove("kesha");
        set.add("tima");
        set.add("kolya");
        set.add("tima");

        iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    static void linkedSetExample() {
        Set<String> set = new LinkedHashSet<>();
//        HashSet<String> set = new HashSet<>();
        set.add("mama");
        set.add("papa");
        set.add("vova");
        set.add("jora");
        set.addAll(Arrays.asList("ksusha", "kesha", "umka"));

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println();

        set.remove("vova");
        set.remove("kesha");
        set.add("tima");
        set.add("kolya");
        set.add("tima");

        iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    static void treeSetExample() {
        Set<String> set = new TreeSet<>();
//        HashSet<String> set = new HashSet<>();
        set.add("mama");
        set.add("papa");
        set.add("vova");
        set.add("jora");
        set.addAll(Arrays.asList("ksusha", "kesha", "umka"));

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println();

        set.remove("vova");
        set.remove("kesha");
        set.add("tima");
        set.add("kolya");
        set.add("tima");

        iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    static void treeSetPersonExample() {
        Set<Person> set = new TreeSet<>(Arrays.asList(
                new Person("Mike", 40),
                new Person("Nick", 78),
                new Person("John", 90)));

        set.add(new Person("Mike", 40));
        Iterator<Person> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    static void treeSetPersonWithoutComparableExample() {
        Set<PersonComparator> set = new TreeSet<>(new Comparator<PersonComparator>() {
            @Override
            public int compare(PersonComparator o1, PersonComparator o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        set.addAll(Arrays.asList(
                new PersonComparator("Mike", 40),
                new PersonComparator("Nick", 78),
                new PersonComparator("John", 90)));

        set.add(new PersonComparator("Mike", 40));
        Iterator<PersonComparator> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    static void hashSetCustomObjects() {
        Person mike = new Person("Mike", 40);
        Set<Person> set = new HashSet<>(Arrays.asList(
                mike,
                new Person("Nick", 78),
                new Person("John", 90)));

        Person mike40 = new Person("Mike", 40);
        set.add(mike40);
        set.add(new Person("John", 90));
        System.out.println("mike equals mike40: " + mike.equals(mike40));
        System.out.println("mike == mike40: " + (mike == mike40));
        System.out.println("mike hashCode: " + mike.hashCode());
        System.out.println("mike40 hashCode: " + mike40.hashCode());
        Iterator<Person> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
