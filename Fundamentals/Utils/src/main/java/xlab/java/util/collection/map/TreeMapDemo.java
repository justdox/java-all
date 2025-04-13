package xlab.java.util.collection.map;

import java.util.TreeMap;

/**
 * @author CodeKing
 */
public class TreeMapDemo {
  public static void main(String[] args) {
    final TreeMap<String, Object> map = new TreeMap<>();
    map.put("c", new Object());
    map.put("b", new Object());
    map.put("a", 123);
    System.out.printf("The final size of treeMap is %d.%n", map.size());
    System.out.println(map);

    map.forEach((k, v) -> System.out.printf("{key: %s, value: %s}.%n", k, v));

  }
}
