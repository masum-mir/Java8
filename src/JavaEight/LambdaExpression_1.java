package JavaEight;

import java.util.*;

interface Student {
    String getName();
}

class Teacher implements Student {
    public String getName() {
        return "masum";
    }
}

class Employee {
    int empId;
    String empName;

    public Employee(int empId, String empName) {
        this.empId = empId;
        this.empName = empName;
    }
}

public class LambdaExpression_1{


//    @Override                 // runnable interface
//    public void run() {
//        for(int i=1; i<=10; i++) {
//            System.out.println("Hello "+ i);
//        }
//    }

//    @Override                   // Comparator<Integer> interface
//    public int compare(Integer a, Integer b) {
//        return b - a;
//    }

    public static void main(String[] args) {

//        Student s = new Teacher();
//        System.out.println(s.getName());

        Student s = () -> "masum";
        System.out.println(s.getName());

        Student s2 = () -> "ashik";
        System.out.println(s2.getName());

        // Runnable functional interface
        Runnable runnable = () -> {
            for(int i=1; i<=3; i++) {
                System.out.println("Hello "+ i);
            }
        };

        Thread thread = new Thread(runnable);
        thread.run();
        System.out.println();

        System.out.println("\nList test: ");
        // Comparator functional interface
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(10);
        list.add(3);
        list.add(5);
      //  Collections.sort(list); // assending order
      //  Collections.sort(list, new LambdaExpression());
        Collections.sort(list, (a,b)-> b-a);
        System.out.println(list);

        System.out.println("\nSet test: ");
        Set<Integer> set = new TreeSet<>();         // ascending order
        set.add(2);
        set.add(24);
        set.add(4);
        System.out.println(set);

        Set<Integer> sset = new TreeSet<>((a,b)-> b-a);     // descending order
        sset.add(2);
        sset.add(24);
        sset.add(4);
        System.out.println(sset);
        System.out.println("\nMap test: ");
        Map<Integer, String> map = new TreeMap<>();         // ascending order
        map.put(2, "a");
        map.put(24, "r");
        map.put(4, "t");
        System.out.println(map);

        Map<Integer, String> mmap = new TreeMap<>((a,b)-> b-a);     // descending order
        mmap.put(2, "a");
        mmap.put(24, "r");
        mmap.put(4, "t");
        System.out.println(mmap);

        // custom soring
        Employee emp = new Employee(1, "abc");
        Employee emp2 = new Employee(2, "efg");
        Employee emp3 = new Employee(3, "mno");
        Employee emp4 = new Employee(4, "pqr");
        List<Employee> l = new ArrayList<>();
        l.add(emp2);
        l.add(emp);
        l.add(emp4);
        l.add(emp3);

//        Collections.sort(l, (a,b)-> a.empId-b.empId);
        Collections.sort(l, (a,b)-> b.empId-a.empId);
        System.out.println(l.get(0).empId +" " + l.get(0).empName);

    }


}
