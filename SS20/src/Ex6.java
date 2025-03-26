import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Ex6 {
    public static void main(String[] args) {
        List<String> items = List.of("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Integer> itemCounts = new HashMap<>();

        for (String item : items) {
            itemCounts.merge(item, 1, Integer::sum);
        }
        System.out.println("Số lần xuất hiện của từng phần tử:");
        itemCounts.forEach((key, value) -> System.out.println(key + ": " + value));
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        System.out.println("Thời điểm thực thi chương trình: " + formattedDateTime);
    }
}
