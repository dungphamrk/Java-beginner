import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Ex5 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>(Arrays.asList("Alice", "Andrew", "Bob", "Anna", "Charles"));
        Predicate<String> predicts = s ->  s.startsWith("A")&&s.length()>=5;
        System.out.println(stringList.stream().filter(predicts).count());
    }
}
