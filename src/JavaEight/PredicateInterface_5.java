package JavaEight;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateInterface_5 {



    public static void main(String[] args) {
        Predicate<Integer> predicate = (x) -> x > 100;
        System.out.println( predicate.test(1000));

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int sum = numbers.stream().filter(x-> x % 2 ==0).mapToInt(n -> n).sum();
        System.out.println(sum);
//        int sum =0;
//        for(int number: numbers) {
//            if(number%2==0) {
//                sum += number;
//            }
//        }

        Predicate<Integer> isEven = x -> x % 2 ==0;
        List<Integer> num = Arrays.asList(1,2,3,4,5);
        for(int n:num) {
            if (isEven.test(n)) {
                System.out.print(n +" ");
            }
        }

        Predicate<String> startsWithLetterT = x-> x.toLowerCase().charAt(0)=='t';
        Predicate<String> endWithLetterT = x-> x.toLowerCase().charAt(x.length()-1)=='t';
        System.out.println(startsWithLetterT.test("test"));
        System.out.println(endWithLetterT.test("test"));

        Predicate<String> and = startsWithLetterT.and(endWithLetterT);
        System.out.println(and.test("test"));
        Predicate<String> or = startsWithLetterT.or(endWithLetterT);
        System.out.println(or.test("atest"));

        System.out.println(startsWithLetterT.negate().test("test"));

        Student s1= new Student("abc", 0);
        Student s2= new Student("mno", 20);

        Predicate<Student> s = x-> x.getId() > 1;
        System.out.println(s.test(s1));

        Predicate<String> predicate1 = Predicate.isEqual("masum");
        System.out.println(predicate1.test("masum"));

    }
    private static class Student{
        String name;
        int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Student(String name, int id) {
            this.name = name;
            this.id = id;
        }
    }
}
