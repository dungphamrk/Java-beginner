package Ex8;

import java.util.List;
import java.util.function.Predicate;

public interface ListProcessor {
    int sumOddNumbers(List<Integer> list);
    static void  printList(List<Integer> list){
        list.stream().filter(i -> i%2!=0).forEach(System.out::println);
    }
    default boolean checkOdd(List<Integer> list){
        Predicate<Integer> isOdd = i -> i % 2 != 0;
        return list.stream().anyMatch(isOdd);
    }
}
