import java.util.HashSet;

public class Ex6 {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (int i = 1; i < 6; i++) {
            set1.add(i);
            set2.add(i+3);
        }
        set1.retainAll(set2);
        System.out.println(set1);
    }
}
