import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> validNumbers = new ArrayList<>();
        List<String> invalidStrings = new ArrayList<>();
        System.out.println("Nhập vào các chuỗi (cách nhau bằng dấu phẩy):");
        String inputStr = scanner.nextLine().trim();
        if (inputStr.isEmpty()) {
            System.out.println("Chuỗi nhập vào trống!");
            return;
        }
        String[] strings = inputStr.split(",");
        for (String str : strings) {
            str = str.trim();
            if (str.isEmpty()) continue; // Bỏ qua các chuỗi rỗng

            try {
                int number = Integer.parseInt(str);
                validNumbers.add(number);
            } catch (NumberFormatException e) {
                invalidStrings.add(str);
            }
        }

        System.out.println("Số lượng chuỗi hợp lệ: " + validNumbers.size());
        System.out.println("Số lượng chuỗi không hợp lệ: " + invalidStrings.size());
        System.out.println("Danh sách các số nguyên đã chuyển đổi thành công: " + validNumbers);
        System.out.println("Danh sách các chuỗi không hợp lệ: " + invalidStrings);
    }
}
