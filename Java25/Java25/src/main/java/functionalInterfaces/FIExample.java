package functionalInterfaces;

@FunctionalInterface
public interface FIExample {
    void m();
}


/**
 * Supplier: T get()
 * Consumer: void accept(T t)
 * Predicate: boolean test()
 * Function: R apply(T t)
 */