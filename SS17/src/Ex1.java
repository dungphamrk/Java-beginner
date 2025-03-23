import java.util.HashSet;

public class Ex1 {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50);
        System.out.println("Các số trong bảng băm là: "+set);
    }
}
