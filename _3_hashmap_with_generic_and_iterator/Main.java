package Homeworks._3_hashmap_with_generic_and_iterator;

public class Main {
    public static void printMap(Map map) {
        System.out.print(map.size() + " ");
        for (Object a: map.keySet()) {
            System.out.print("{" + a + ", " + map.get(a) + "} ");
        } System.out.println();
    }

    public static void main(String[] args) {
        HashMap<String, Integer> myMap = new HashMap<String, Integer>();
        myMap.put("a", 1);
        myMap.put("b", 2);
        myMap.put("c", 3);
        myMap.put("d", 4);
        printMap(myMap);

        System.out.print(myMap.containsKey("a"));
        System.out.print(myMap.containsKey("f"));
        System.out.print(myMap.containsValue(3));
        System.out.print(myMap.containsValue(6));

        myMap.remote("a");
        printMap(myMap);

        myMap.clear();
        printMap(myMap);
    }
}