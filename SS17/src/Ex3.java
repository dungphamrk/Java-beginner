import java.util.HashSet;

public class Ex3 {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 1; i <= 10; i++) {
            set.add(i);
        }
        set.removeIf(i -> i%2==0 );
        System.out.println("HashSet sau khi xóa là: " +set);
    }
}
