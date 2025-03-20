import java.util.ArrayList;

public class Ex4 {
    public static void main(String[] args) {
        ArrayList<Integer> listEx4 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listEx4.add(i);
        }
        System.out.println("Tổng các phần tử trong danh sách là: "+listEx4.stream().reduce(0, Integer::sum));
    }
}
