package JavaEight;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryBinaryOperator_10 {
    public static void main(String[] args) {

        // unary operator
        Function<Integer, Integer> function1 = x-> x * x;
        Function<String, String> function2 = str-> str.toLowerCase();

        UnaryOperator<Integer> unaryOperator = x-> x * x;
        System.out.println(unaryOperator.apply(10));

        UnaryOperator<String> unaryOperator1 = str -> str.toUpperCase();
        System.out.println(unaryOperator1.apply("masum"));

        // binary operator
        BiFunction<String, String, String> biFunction = (str1, str2) -> str1 + str2;

        BinaryOperator<String> binaryOperator = (str1, str2) -> str1 +" "+ str2;
        System.out.println(binaryOperator.apply("hello", "world"));

    }
}
