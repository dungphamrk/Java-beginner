import java.util.ArrayList;

public class Ex7 {
    public static void main(String[] args) {
        ArrayList<Integer> listEx7 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            listEx7.add((int) (Math.random() * 10));
        }
        System.out.println("Chuỗi ban đầu");
        System.out.println(listEx7);
        ArrayList<Integer> uniqueList = new ArrayList<>();
        for (int item : listEx7) {
            if (listEx7.indexOf(item) == listEx7.lastIndexOf(item)) {
                uniqueList.add(item);
            }
        }
        System.out.println("tất cả các phần tử xuất hiện đúng một lần: ");
        System.out.println(uniqueList);
        int [] arr = new  int [10];
        for(int item:listEx7){
            arr[item]++;
        }
        System.out.println("các phần tử bị trùng lặp kèm số lần xuất hiện của chúng.");
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>1){
                System.out.println(i+" - "+arr[i]+" Lần");
            }
        }
    }
}
