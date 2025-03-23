import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Ex5 {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer>  set2 = new HashSet<Integer>();
        for (int i = 1; i < 6; i++) {
            set1.add(i);
            set2.add(i+3);
        }
        TreeSet<Integer> setFinal = new TreeSet<>(set1);
        setFinal.addAll(set2);
        System.out.println(setFinal);
    }
}
