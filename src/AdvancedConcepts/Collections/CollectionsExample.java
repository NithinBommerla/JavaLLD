package AdvancedConcepts.Collections;

import java.util.*;

public class CollectionsExample {

    public static void main(String[] args) {
        // List
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 10; i++) list.add(i);
        System.out.println("List: " +list);
        // Using iterator
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) { // list.removeIf(value -> value % 5 == 0);
            int value = iterator.next();
            if(value % 5 == 0) iterator.remove();
        }
        System.out.println("Updated List: " +list);
        // Queue
        Queue<String> queue = new PriorityQueue<>();
        for(int i = 1; i <= 10; i++) queue.add("el"+i);
        System.out.println("Queue: "+queue);
        // Set
        Set<String> set = new HashSet<>();
        for(int i = 1; i <= 10; i++) set.add("el"+i);
        System.out.println("Set: "+set); // Order is not guaranteed in hashset
        // Map
        Map<String, Integer> map = new HashMap<>();
        for(int i = 1; i <= 10; i++) map.put("el"+i, i);
        System.out.println("Map: "+map); // / Order is not guaranteed in hashmap
    }
}
