package Ex3;

import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        BinaryOperator<Integer> add = MathOperations::add;
        BinaryOperator<Integer> dev = MathOperations::divide;
        BinaryOperator<Integer> sub = MathOperations::subtract;
        BinaryOperator<Integer> multiply = MathOperations::multiply;
        System.out.println(add.apply(3,4));
        System.out.println(dev.apply(3,4));
        System.out.println(sub.apply(3,4));
        System.out.println(multiply.apply(3,4));
    }
}
