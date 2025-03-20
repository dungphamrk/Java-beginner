import java.util.ArrayList;
import java.util.List;

public class Ex2 {
    public static void main(String[] args) {
        ArrayList<Integer> listInt = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listInt.add(i);
        }
        listInt.removeIf(n->n%3==0);
        System.out.println(listInt);
    }
}
