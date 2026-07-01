package streams;

import java.util.Comparator;
import java.util.stream.Stream;

public class IntermediateOperations {
    static void main() {
        filter();
        distinct();
        sortedComparator();
    }

    static void sortedComparator(){
        record Employee(String name, Integer age){}
        Employee ray = new Employee("Ray", 29);
        Employee mary = new Employee("Mary", 21);

        Stream.of(ray, mary)
                .sorted(Comparator.comparing(p -> p.age))
                .forEach(System.out::println);
    }

    static void distinct(){
        Stream.of("parrot", "lion", "parrot")
                .peek(s -> System.out.println("1. "+ s))
                .distinct()
                .forEach(s -> System.out.println("2. "+ s));
    }

    static void filter(){
        Stream.of("mayor", "contractor", "president")
                .filter( position -> position.length() > 6)
                .forEach(System.out::println);
    }
}
