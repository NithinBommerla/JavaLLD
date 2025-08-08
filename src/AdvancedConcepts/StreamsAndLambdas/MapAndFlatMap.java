package AdvancedConcepts.StreamsAndLambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndFlatMap {
    public static void main(String[] args) {
//        List<String> input = List.of("Apple", "Banana");
//        // Map
//        List<String[]> mapDemo = input.stream().map(str -> str.split("")).collect(Collectors.toList());
//        mapDemo.forEach(str -> System.out.println(Arrays.toString(str)));
//
//        // FlatMap
//        List<String> flatmapDemo = input.stream().map(str -> str.split(""))
//                .flatMap(Arrays::stream).collect(Collectors.toList());
//        System.out.println(flatmapDemo);

        List<List<List<String>>> deepList = List.of(
                List.of(
                        List.of("a", "b"),
                        List.of("c", "d")
                ),
                List.of(
                        List.of("e", "g"),
                        List.of("h", "j")
                )
        );

        System.out.println(deepList);

        // Goal to return List of List just the inner Lists flattened
        List<List<String>> innerFlattenedList = deepList.stream()
                .flatMap(List::stream)
                .toList();

        System.out.println(innerFlattenedList);

        // Goal to return List of all strings flattened
        List<String> deepFlattenedList = deepList.stream()
                .flatMap(List::stream)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(deepFlattenedList);

        // Goal to return String of all Strings Flattened
        String flattenedDeepList = deepList.stream()
                .flatMap(list -> list.stream())
                .flatMap((innerList -> innerList.stream()))
                .collect(Collectors.toList())
                .stream().collect(Collectors.joining(","));

        System.out.println(flattenedDeepList);

    }
}
