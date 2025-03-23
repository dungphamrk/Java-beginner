import java.util.HashSet;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<String>();
        set.add("Java");
        set.add("C++");
        set.add("Python");
        set.add("JavaScript");
        Scanner sc = new Scanner(System.in);
        String findString =sc.nextLine();
        if(set.contains(findString)){
            System.out.println(findString + " có tồn tại trong hashset");
        }else{
            System.out.println(findString + " Không tồn tại trong hashset");
        }

    }
}
