package JavaEight;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodConstructorReference_11 {
    public static void main(String[] args) {
        MethodConstructorReference_11 obj = new MethodConstructorReference_11();

        List<String> st = Arrays.asList("abc", "def", "ijk", "mno");
//        st.forEach(x-> System.out.println(x));
//        st.forEach(x -> display(x));
//        st.forEach(MethodConstructorReference::display);
        st.forEach(obj::display1);

//        List<Student1> student1 = st.stream().map(x -> new Student1(x)).collect(Collectors.toList());
        List<Student1> student1 = st.stream().map(Student1::new).collect(Collectors.toList());

        System.out.println(student1);

    }
    public static void display(String s) {
        System.out.println(s);
    }
    public void display1(String s) {
        System.out.println(s);
    }
}

class Student1 {
    String name;

    public Student1(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student1{" +
                "name='" + name + '\'' +
                '}';
    }
}