package JavaEight;

/*
    Functional interface - interface having exactly single abstract method but can have any number of defaults and static methods. we can invoke lambda expression by using functional interface.

 */

@java.lang.FunctionalInterface
interface  MyInterface {
    public void sayHello();

    // any number of default or static method does not effect functional interface
    default void sayBye(){};
    static void sayOk(){};
}

public class FunctionalInterface_2 {

    public static void main(String[] args) {

    }
}
