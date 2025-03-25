import java.util.function.Function;

public class Ex2 {
    public static void main(String[] args) {
        Function<Integer, Integer> f = x -> x * x + 3 * x + 2;
        System.out.println("f(1) = " + f.apply(1));
        System.out.println("f(2) = " + f.apply(2));
        System.out.println("f(3) = " + f.apply(3));
    }
}
