package Ex7;

import java.util.List;

public interface ListProcessor {
    boolean containsNegative(List<Integer> list);
    static void printList(List<Integer> list){
        list.forEach(System.out::println);
    }
}
