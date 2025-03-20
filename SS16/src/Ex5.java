import java.util.ArrayList;

public class Ex5 {
    public static void main(String[] args) {
        ArrayList<Integer> listEx5  = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            listEx5.add((int) (Math.random() * 10));
        }
        int [] arr = new  int [10];
        for(int item:listEx5){
            arr[item]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                System.out.println(i+" - "+arr[i]+" Lần");
            }
        }

    }
}
