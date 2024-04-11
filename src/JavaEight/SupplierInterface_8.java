package JavaEight;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SupplierInterface_8 {
    public static void main(String[] args) {

        Supplier<Integer> supplier1 = ()-> 1;
        Supplier<List<Integer>> supplier2 = ()-> Arrays.asList(1,2,3);
        System.out.println(supplier1.get());
        System.out.println(supplier2.get());

        Predicate<Integer> predicate = x -> x %2 ==0;
        Function<Integer, Integer> function = x -> x * x;
        Consumer<Integer> consumer = x-> System.out.println(x);
        Supplier<Integer> supplier3 = ()-> 100;

        if(predicate.test(supplier3.get())) {
            consumer.accept(function.apply(supplier3.get()));
//            consumer.accept(function.apply(100));
//            consumer.accept(10000);
        }

    }
}
