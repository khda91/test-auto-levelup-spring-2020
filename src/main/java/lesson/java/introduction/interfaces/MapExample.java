package lesson.java.introduction.interfaces;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExample {

    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<String, String>();
        Map<String, String> linkedMap = new LinkedHashMap<String, String>();
        Map<String, String> treeMap = new TreeMap<String, String>();

        MapExample mapExample = new MapExample();
        Map<String, String> map = mapExample.createMap("val=uuuu", "=");
        map.get("val");
    }

    public Map<String, String> createMap(String string, String regExp) {
        Map<String, String> hashMap = new TreeMap<String, String>();
        // парсинг строки
        hashMap.put("asf", "asf");
        return hashMap;
    }
}
