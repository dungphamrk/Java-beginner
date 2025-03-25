import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ex8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> romanMap = new TreeMap<>();
        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");

        System.out.print("Nhập vào một số nguyên từ 1 đến 3999: ");
        int number = scanner.nextInt();
        StringBuilder addRoman = new StringBuilder();

        if (number < 1 || number > 3999) {
            System.out.println("Số phải nằm trong khoảng từ 1 đến 3999.");
        } else {
            for (Map.Entry<Integer, String> entry : ((TreeMap<Integer, String>) romanMap).descendingMap().entrySet()) {
                while (number >= entry.getKey()) {
                    addRoman.append(entry.getValue());
                    number -= entry.getKey();
                }
            }
            System.out.println("Số La Mã tương ứng: " + addRoman);
        }
    }
}
