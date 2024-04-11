package JavaEight;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterface_7 {
    public static void main(String[] args) {
        Consumer<String> consumer = s-> System.out.println(s);
        consumer.accept("masum");

        Consumer<List<Integer>> listConsumer1 = x-> {
          for(Integer i: x) {
              System.out.println(i * 10);
          }
        };
        listConsumer1.accept(Arrays.asList(1,2,3,4,5));

        System.out.println();

        Consumer<List<Integer>> listConsumer2 = x-> {
            for(Integer i: x) {
                System.out.println(i);
            }
        };
        listConsumer2.andThen(listConsumer1).accept(Arrays.asList(1,2,3,4,5));


    }
}
