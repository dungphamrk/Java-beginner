import java.util.*;

public class Ex6 {
    public static void main(String[] args) {
        Map<String, Integer> students = new LinkedHashMap<>();
        students.put("Nguyễn Văn A", 7);
        students.put("Nguyễn Văn B", 1);
        students.put("Nguyễn Văn C", 2);
        students.put("Nguyễn Văn D", 3);
        students.put("Nguyễn Văn E", 4);

        System.out.println("Danh sách học sinh và điểm số của họ theo thứ tự thêm vào là:  " + students);
        double sum = 0;
        for (Integer value : students.values()) {
            sum += value;
        }
        double average = sum / students.size();
        System.out.println("Điểm trung bình của tất cả học sinh: " + average);

        List<String> studentRemoveList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            if (entry.getValue() < 5.0) {
                studentRemoveList.add(entry.getKey());
            }
        }
        for (String key : studentRemoveList) {
            students.remove(key);
        }
        System.out.println("Danh sách học sinh sau khi xóa: ");
        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " - Điểm: " + entry.getValue());
        }
    }
}
