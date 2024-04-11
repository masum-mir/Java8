package JavaEight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionInterface_6 {
    public static void main(String[] args) {
        Function<String, Integer> fun1 = x -> x.length();
        System.out.println(fun1.apply("masum"));

        Function<String, String> fun2 = x -> x.substring(0,2);
        System.out.println(fun2.apply("masum"));

        Function<List<Student>, List<Student>> studentsWithMaPrefix = x -> {
            List<Student> list = new ArrayList<>();
            for(Student st: x) {
                if(fun2.apply(st.getName()).equalsIgnoreCase("ma")) {
                    list.add(st);
                }
            }
            return list;
        };

        Student s1 = new Student(10,"mas");
        Student s2 = new Student(20,"pmas");
        Student s3 = new Student(30,"masp");
        List<Student> students = Arrays.asList(s1,s2,s3);
        List<Student> filterStudent = studentsWithMaPrefix.apply(students);
        System.out.println(filterStudent);

        Function<String, String> fun3 = x-> x.toUpperCase();
        Function<String, String> fun4 = x->x.substring(0, 3);
        Function<String, String> StringFunction = fun3.andThen(fun4);
        System.out.println(StringFunction.apply("masum"));
        System.out.println(fun3.andThen(fun4).apply("masum"));

        Function<Integer, Integer> fun5 = x-> 2 * x;
        Function<Integer, Integer> fun6 = x->x * x * x;
        System.out.println(fun5.andThen(fun6).apply(3));
        System.out.println(fun6.andThen(fun5).apply(3));

        System.out.println(fun5.compose(fun6).apply(3));
        System.out.println(fun6.compose(fun5).apply(3));

        Function<String, String> identityFunction = Function.identity();
        System.out.println(identityFunction.apply("masum"));


    }
    private static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
