import java.util.ArrayList;

public class Ex6 {
    public static void main(String[] args) {
        ArrayList<Integer> listEx6 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            listEx6.add((int) (Math.random() * 10));
        }
        System.out.println("Chuỗi ban đầu");
        System.out.println(listEx6);
        ArrayList<Integer> uniqueList = new ArrayList<>();
        for (int item : listEx6) {
            if (!uniqueList.contains(item)) {
                uniqueList.add(item);
            }
        }
        System.out.println("Chuỗi sau khi rút gọn");
        System.out.println(uniqueList);
    }
}
