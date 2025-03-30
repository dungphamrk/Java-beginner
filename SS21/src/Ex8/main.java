package Ex8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> phoneNumbers = new ArrayList<>();
        List<String> invalidPhoneNumbers = new ArrayList<>();
        System.out.println("Nhập vào các số điện thoại(cách nhau bằng dấu phẩy)");
        String inputStr = scanner.nextLine();
        String[] strings = inputStr.split(",");
        for (String str : strings) {
            str = str.trim();
            try {
                InvalidPhoneNumberLengthException.validatePhoneNumber(str);
                phoneNumbers.add(str);
            } catch (InvalidPhoneNumberLengthException e) {
                invalidPhoneNumbers.add(str + ": " + e.getMessage());
            }
        }
        System.out.println("Danh sách số điện thoại hợp lệ: " + phoneNumbers);

        if (!invalidPhoneNumbers.isEmpty()) {
            System.out.println("Danh sách số điện thoại không hợp lệ:");
            for (String invalid : invalidPhoneNumbers) {
                System.out.println(invalid);
            }
        } else {
            System.out.println("Tất cả số điện thoại đều hợp lệ.");
        }
    }
}
