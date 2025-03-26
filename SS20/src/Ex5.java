import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Ex5 {
    public static void main(String[] args) {
        List<Integer> normalList = List.of(10, 5, 8, 20, 7);
        List<Integer> singleElementList = List.of(10);
        List<Integer> allSameList= List.of(10, 10, 10);
        Optional<Integer> result1 =normalList.stream().sorted(Comparator.reverseOrder()).skip(1).limit(1).findFirst();
        result1.ifPresentOrElse(System.out::println,
                ()-> System.out.println("Không tìm thấy số lớn thứ hai"));
        Optional<Integer> result2 =singleElementList.stream().sorted(Comparator.reverseOrder()).skip(1).limit(1).findFirst();
        result2.ifPresentOrElse(System.out::println,
                ()-> System.out.println("Không tìm thấy số lớn thứ hai"));
        Optional<Integer> result3 =allSameList.stream().sorted(Comparator.reverseOrder()).skip(1).limit(1).findFirst();
        result3.ifPresentOrElse(System.out::println,
                ()-> System.out.println("Không tìm thấy số lớn thứ hai"));
    }
}
