package JavaEight;


import java.util.function.*;

public class BiPredicateFunctionConsumer_9 {

    public static void main(String[] args) {

        // predicate
        Predicate<Integer> predicate = x -> x %2 ==0;
        System.out.println(predicate.test(2));

        BiPredicate<Integer, Integer> biPredicate = (x,y) -> x %2 ==0 && y %2==0;
        System.out.println(biPredicate.test(2,3));

        BiPredicate<String, Integer> biPredicate1 = (str, x) -> str.length() == x;
        System.out.println(biPredicate1.test("masum", 5));

        // function
        Function<String, Integer> function = str -> str.length();
        System.out.println(function.apply("masum"));
        BiFunction<String, String, Integer> biFunction = (x,y) -> x.length() + y.length();
        System.out.println(biFunction.apply("abc", "efg"));

        // consumer
        Consumer<Integer> consumer = x-> System.out.println(x);
        consumer.accept(10);

        BiConsumer<Integer, Integer> biConsumer = (x,y)-> System.out.println(x+y);
        biConsumer.accept(10,20);

        //supplier
        Supplier<String> supplier = ()-> "test";
        System.out.println(supplier.get());


    }
}
