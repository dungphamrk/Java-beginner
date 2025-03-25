import java.util.*;

public class Ex7 {
    public static <List> void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử : ");
        int n = scanner.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("arr[%d] = ",i);
            arr[i] = scanner.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int k : arr) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (k == arr[j]) {
                    count++;
                }
            }
            map.put(k, count);
        }

        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, Map.Entry.comparingByValue());
        System.out.println("Tần xuất xuất hiện của các giá trị trong mảng là: ");
        for (Map.Entry<Integer, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
