package JavaEight;

interface Parent {
    public void sayHello();
}

@java.lang.FunctionalInterface
interface Child extends Parent {

    default void sayHello3() {
        
    }
}

public class InheritanceFunctionalInterface_3 {
    public static void main(String[] args) {

    }
}
