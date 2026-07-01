package functionalInterfaces;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.function.*;

public class FIExampleImplementation {
    static void main() {
        Evaluate<Integer> lambda = i -> i < 0;
        System.out.println("Evaluate: "+ lambda.isNegative(-1));

        Predicate<Integer> predicate = i -> i <0;
        System.out.println("Predicate: "+ predicate.test(8));

        System.out.println("Check for even? " + check(4, n -> n % 2 == 0));

        BiPredicate<String, Integer> checkLength = (str, len) -> str.length() == len;
        System.out.println("checkLength :" + checkLength.test("Vatican City", 9));

        supplier();
        consumer();
        function();
    }

    interface Evaluate<T> {
        boolean isNegative(T t); //similar to predicate
    }

    public static <T> boolean check(T t, Predicate<T> lambda){
        return lambda.test(t);
    }

    private static void supplier() {
        Supplier<LocalDateTime> supTime = () -> LocalDateTime.now();
        System.out.println("Supplier Time: " + supTime.get());
    }

    private static void consumer(){
        Consumer<String> printC = s -> System.out.println(s);
        printC.accept("Consumer functional interface");
        List<String> names = List.of("John", "Mary");
        names.forEach(printC);

        var mapCityCapitals = new HashMap<String, String>();
        BiConsumer<String, String> biCon = (key, value) -> mapCityCapitals.put(key, value);
        biCon.accept("Dublin", "Ireland");
        biCon.accept("Berlin", "Germany");

        System.out.println(mapCityCapitals);
        BiConsumer<String, String> mapPrint = (key, val) -> System.out.println(key + " is the capital of: " + val);
        mapCityCapitals.forEach(mapPrint);
    }

    private static void function(){
        Function<String, Integer> fn = s -> s.length();
        System.out.println("Function: " + fn.apply("Venice"));

        BiFunction<String, String, Integer> biFn = (s1, s2) -> s1.length() + s2.length();
        System.out.println("BiFunction: " + biFn.apply("John", "Wick"));
    }

    // unaryBinaryOperator & BinaryOperator

}

