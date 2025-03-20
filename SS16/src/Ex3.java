import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Ex3 {
    public static void main(String[] args) {
        ArrayList<Integer> listEx3 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listEx3.add(i);
        }
        System.out.println("Phần tử lớn nhất của danh sách là: ");
        System.out.println(Collections.max(listEx3));
        System.out.println("Phần tử nhỏ nhất của danh sách là: ");
        System.out.println(Collections.min(listEx3));
    }
}
