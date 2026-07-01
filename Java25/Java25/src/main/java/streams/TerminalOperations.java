package streams;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperations {
    static void main() {
        collectors();
        groupingBy();
        partitioningBy();
    }

    private static void partitioningBy(){
        Stream<String> names = Stream.of("Peter", "Tom", "Joe", "Jack", "Alan");
        Map<Boolean, List<String>> map = names.collect(
         Collectors.partitioningBy( s -> s.startsWith("J"))
        );
        System.out.println(map);
    }

    private static void groupingBy(){
        Stream<String> names = Stream.of("Peter", "Tom", "Joe", "Tom", "Alan");
        TreeMap<Integer, List<String>> map = names.collect(
                Collectors.groupingBy(
                        n -> n.length(),
                        TreeMap::new,
                        Collectors.toList()
                )
        );

        System.out.println(map);
    }

    private static void collectors(){
        Map<Integer, String> map = Stream.of("cake", "cookie", "tart", "biscuts")
                .collect(
                        Collectors.toMap(s -> s.length(),
                                s -> s,
                                (s1, s2) -> s1+ ","+ s2)
                );
        System.out.println(map);
        System.out.println(map.getClass());


        Map<String, Integer> treeMap = Stream.of("cake", "cookie", "tart", "cake","biscuts")
                .collect(
                        Collectors.toMap(s -> s,
                                s -> s.length(),
                                (len1, len2) -> len1 + len2,
                                ()-> new TreeMap<>())
                );
        System.out.println(treeMap);
        System.out.println(treeMap.getClass());
    }
}
