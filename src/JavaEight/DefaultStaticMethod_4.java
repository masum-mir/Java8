package JavaEight;

interface A {
    default void test() {
        System.out.println("Default test A");
    }

    static void staticTest() {
        System.out.println("Static test A");
    }
}
interface B {
    default void test() {
        System.out.println("Default test B");
    }
    static void staticTest() {
        System.out.println("Static test B");
    }
}


public class DefaultStaticMethod_4 implements A, B {

    @Override
    public void test() {
        B.super.test();
        A.super.test();
    }

//    @Override
//    public void test() {
//        System.out.println("parent class");
//    }

    public static void main(String[] args) {
        DefaultStaticMethod_4 obj = new DefaultStaticMethod_4();
        obj.test();

        A.staticTest();
        B.staticTest();
    }
}
