import java.util.*;

public class Ex8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            set.add((int) (Math.random()*10));
        }
        System.out.println("Dãy số được tạo ngẫu nhiên: ");
        System.out.println(set);
        System.out.println("Nhập tổng k: ");
        int sum =sc.nextInt();
        Set<String> foundsPair = new HashSet<>();

        for(int num :set){
            for(int num2 : set){
                if(num == num2){
                    break;
                }
                if(num2 > sum ){
                    break;
                }
                if(num+num2==sum){
                    foundsPair.add(num+"-"+num2);
                }
            }
        }
        for(String pair:foundsPair){
            System.out.println(pair);
        }
    }
}
