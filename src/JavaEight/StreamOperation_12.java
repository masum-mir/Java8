package JavaEight;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperation_12 {
    public static void main(String[] args) {

        // imperative approach
        int[] arr = {1,2,3,4,5};
        int sum =0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] %2 ==0) {
                sum += arr[i];
            }
        }
        System.out.println(sum);

        //stream
        int[] arr2 = {1,2,3,4,5};
        int sum2 = Arrays.stream(arr2).filter(n -> n%2 ==0).sum();
        System.out.println(sum2);

        //stream create 5 ways
        List<String> l = Arrays.asList("apple", "mango", "banana");
        Stream<String> stream1 = l.stream();

        String ar[] = {"apple", "mango", "banana"};
        Stream<String> stream2 = Arrays.stream(ar);

        Stream<Integer> stream3 = Stream.of(1, 2, 3);
        Stream<Integer> stream4 = Stream.iterate(0, x -> x + 1).limit(10);  // infinite so use limit
        Stream<String> stream5 = Stream.generate(() -> "hello").limit(5);// infinite so use limit
        Stream<Integer> stream6 = Stream.generate(()-> (int) (Math.random() * 10)).limit(5);

        System.out.println(stream3);

        //stream operation
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,2,5,23,24,1, 8);
        List<Integer> filterList = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(filterList);

        List<Integer> mapList = filterList.stream().map(x -> x / 2).collect(Collectors.toList());
        System.out.println(mapList);

        List<Integer> mapList2 = list.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x / 2)
                .distinct()
                .sorted((a,b)-> b-a)
                .limit(3)
                .skip(1)
                .collect(Collectors.toList());
        System.out.println(mapList2);

        List<Integer> mapList3 = Stream.iterate(0, x -> x + 1)
                .limit(101)
                .skip(1)
                .filter(x-> x%2==0)
                .map(x-> x/10)
                .distinct()
                .sorted()
                .peek(x-> System.out.println(x))
                .collect(Collectors.toList());

        System.out.println(mapList3);

         Integer  mapList4 = Stream.iterate(0, x -> x + 1)
                .limit(101)
                .map(x-> x/10)
                .distinct()
//                .peek(System.out::println)
                .max((a,b)->b-a).get();
        System.out.println(mapList4);

        Long  mapList5 = Stream.iterate(0, x -> x + 1)
                .limit(101)
                .map(x-> x/10)
                .distinct()
                .count();
        System.out.println(mapList5);

        List<Integer> list6 = Arrays.asList(1,2,3,4,5,6,7,8);
        list6.parallelStream();     // use only large dataset

    }
}
