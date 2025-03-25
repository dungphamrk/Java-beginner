package Ex7;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListProcessor processor = new ListProcessorImpl();
        List<Integer> list = List.of(1, -2, 3, 4, -5);
        ListProcessor.printList(list);
        boolean hasNegative = processor.containsNegative(list);
        if (hasNegative) {
            System.out.println("Danh sách chứa số âm");
        } else {
            System.out.println("Danh sách không chứa số âm");
        }
    }
}
