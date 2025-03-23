package Ex10;

import java.util.HashSet;
import java.util.Set;

public class ContactManager {
    public static void main(String[] args) {
        Set<Contact> contactSet = new HashSet<>();

        Contact contact1 = new Contact("Alice", "123456789");
        Contact contact2 = new Contact("Bob", "987654321");
        Contact contact3 = new Contact("Charlie", "555555555");
        Contact contact4 = new Contact("Alice", "123456789");
        contactSet.add(contact1);
        contactSet.add(contact2);
        contactSet.add(contact3);


        System.out.println("Danh sách liên hệ ban đầu:");
        for (Contact contact : contactSet) {
            System.out.println(contact);
        }

        String deletePhoneNumber = "987654321";
        if (contactSet.remove(new Contact("", deletePhoneNumber))) {
            System.out.println("Đã xóa số điện thoại: " + deletePhoneNumber);
        } else {
            System.err.println("Không tìm thấy số điện thoại trong danh sách");
        }
        System.out.println("Danh sách liên hệ sau khi xóa:");
        for (Contact contact : contactSet) {
            System.out.println(contact);
        }
        String testPhoneNumber = "555555555";
        if (contactSet.contains(new Contact("", testPhoneNumber))) {
            System.out.println("Số điện thoại " + testPhoneNumber + " tồn tại trong danh sách liên lạc");
        } else {
            System.err.println("Số điện thoại " + testPhoneNumber + " không tồn tại");
        }
    }
}
