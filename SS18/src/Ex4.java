import java.util.Map;
import java.util.TreeMap;

public class Ex4 {
    public static void main(String[] args) {
        Map<String, Integer> employees = new TreeMap<>();
        employees.put("NV123", 2000);
        employees.put("NV111", 3000);
        employees.put("NV222", 4000);
        employees.put("NV333", 5000);
        employees.put("NV444", 4500);
        System.out.println("Danh sách nhân viên theo thứ tự mã nhân viên theo thứ tự tăng dần: "+ employees);
        employees.put("NV123", 6000);
        employees.remove("NV111");
        employees.remove("NV222");
        System.out.println("Danh sách nhân viên sau khi xóa: "+ employees);

    }

}
