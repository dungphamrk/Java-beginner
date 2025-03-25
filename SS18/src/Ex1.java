import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex1 {
    public static void main(String[] args) {
        Map<String, Integer> students = new HashMap<>();
        students.put("Nguyễn Văn A", 7);
        students.put("Nguyễn Văn B", 1);
        students.put("Nguyễn Văn C", 2);
        students.put("Nguyễn Văn D", 3);
        students.put("Nguyễn Văn E", 4);

        System.out.println("Điểm số của sinh viên: " +students.get("Nguyên Văn A"));
    }

}
