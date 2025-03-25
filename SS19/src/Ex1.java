import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ex1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("");
        list.add("Java");
        list.add("Lambda");
        list.add("Stream");
        list.add("");
        list.add("Functional");
        Predicate<String>  predicate = s -> !s.isEmpty();
        list.stream().filter(predicate).forEach(System.out::println);
    }
}
