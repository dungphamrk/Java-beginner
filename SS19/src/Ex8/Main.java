package Ex8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, -3, 4, 5, 6, 7, -8, -9, -10));
        ListProcessor processor = new ListProcessorImpl();
        int sumOdd = processor.sumOddNumbers(list);
        System.out.println("Sum Odd: " + sumOdd);
        if(processor.checkOdd(list)) {
            ListProcessor.printList(list);
        }else{
            System.out.println("Không có phần tử lẻ");
        }
    }
}
