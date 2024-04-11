package JavaEight;

interface Employeee {
    double getSalary();
    String getName();

}

interface Students {
    int studentId();
}

public class AnonymousLambda{

    private void doSomething() {
        Students st = () -> {
            int n = 3;
            System.out.println(n);
            return 100;
        };
        Students st2 = new Students() {
            int n= 2;
            @Override
            public int studentId() {
                System.out.println(this.n);
                return 101;
            }
        };
    }

    public static void main(String[] args) {
        Employeee emp = new Employeee() {
            @Override
            public double getSalary() {
                return 10;
            }

            @Override
            public String getName() {
                return "masum";
            }
        };
        System.out.println(emp.getSalary());
    }
}
