package lesson.java.introduction.collections.map;

import lesson.java.introduction.collections.Person;
import lesson.java.introduction.collections.PersonComparator;

import java.util.*;

public class MapExample {

    public static void main(String[] args) {
        System.out.println("+++++++++++++++++++++");
        System.out.println("====== HashMap" + "=======");
        hashMapExample();
        System.out.println("+++++++++++++++++++++");
        System.out.println();

        System.out.println("+++++++++++++++++++++");
        System.out.println("====== LinkedMap =======");
        linkedMapExample();
        System.out.println("+++++++++++++++++++++");
        System.out.println();

        System.out.println("+++++++++++++++++++++");
        System.out.println("====== TreeMap =======");
        treeMapExample();
        System.out.println("+++++++++++++++++++++");
        System.out.println();

        System.out.println("+++++++++++++++++++++");
        System.out.println("====== TreeMapPerson =======");
        treeMapPersonExample();
        System.out.println("+++++++++++++++++++++");

        System.out.println("+++++++++++++++++++++");
        System.out.println("====== TreeMapPersonComparator =======");
        treeMapPersonWithoutComparableExample();
        System.out.println("+++++++++++++++++++++");
//
//        System.out.println("+++++++++++++++++++++");
//        System.out.println("====== HashSetCustomObjects =======");
//        hashSetCustomObjects();
//        System.out.println("+++++++++++++++++++++");
    }

    static void hashMapExample() {
//        Map<String, String> map = new HashMap<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("mama", "129");
        map.put("papa", "123");
        map.put("vova", "443");
        map.put("jora", "000");

        System.out.println(map.get("jora"));

        Set<String> iterator = map.keySet();
        for (String key : iterator) {
            System.out.println("key: " + key + "; value: " + map.get(key));
        }
        System.out.println();
        System.out.println();

        map.remove("vova");
        map.remove("kesha");
        map.put("tima", "321");
        map.put("kolya", "123");
        map.put("tima", "123");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println("key: " + entry.getKey() + "; value: " + entry.getValue());
        }
        System.out.println();
    }

    static void linkedMapExample() {
        //        Map<String, String> map = new HashMap<>();
        Map<String, String> map = new LinkedHashMap<>();
        map.put("mama", "129");
        map.put("papa", "123");
        map.put("vova", "443");
        map.put("jora", "000");

        System.out.println(map.get("jora"));

        Set<String> iterator = map.keySet();
        for (String key : iterator) {
            System.out.println("key: " + key + "; value: " + map.get(key));
        }
        System.out.println();
        System.out.println();

        map.remove("vova");
        map.remove("kesha");
        map.put("tima", "321");
        map.put("kolya", "123");
        map.put("tima", "123");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println("key: " + entry.getKey() + "; value: " + entry.getValue());
        }
        System.out.println();
    }

    static void treeMapExample() {
        //        Map<String, String> map = new HashMap<>();
        Map<String, String> map = new TreeMap<>();
        map.put("mama", "129");
        map.put("papa", "123");
        map.put("vova", "443");
        map.put("jora", "000");

        System.out.println(map.get("jora"));

        Set<String> iterator = map.keySet();
        for (String key : iterator) {
            System.out.println("key: " + key + "; value: " + map.get(key));
        }
        System.out.println();
        System.out.println();

        map.remove("vova");
        map.remove("kesha");
        map.put("tima", "321");
        map.put("kolya", "123");
        map.put("tima", "123");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println("key: " + entry.getKey() + "; value: " + entry.getValue());
        }
        System.out.println();
    }

    static void treeMapPersonExample() {
        Map<Person, String> set = new TreeMap<>();
        Person mike = new Person("Mike", 40);
        Person nick = new Person("Nick", 78);
        Person john = new Person("John", 90);
        set.put(mike, "low");
        set.put(nick, "mid");
        set.put(john, "high");

        Set<Map.Entry<Person, String>> entries = set.entrySet();
        for (Map.Entry<Person, String> entry : entries) {
            System.out.println("key: " + entry.getKey() + "; value: " + entry.getValue());
        }
        System.out.println();
    }

    static void treeMapPersonWithoutComparableExample() {
        Map<PersonComparator, String> set = new TreeMap<>(new Comparator<PersonComparator>() {
            @Override
            public int compare(PersonComparator o1, PersonComparator o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        PersonComparator mike = new PersonComparator("Mike", 40);
        PersonComparator nick = new PersonComparator("Nick", 78);
        PersonComparator john = new PersonComparator("John", 90);
        set.put(mike, "low");
        set.put(nick, "mid");
        set.put(john, "high");

        Set<Map.Entry<PersonComparator, String>> entries = set.entrySet();
        for (Map.Entry<PersonComparator, String> entry : entries) {
            System.out.println("key: " + entry.getKey() + "; value: " + entry.getValue());
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
