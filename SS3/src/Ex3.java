import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        double point=0;
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhập điểm cần phân loại: ");
        point=sc.nextDouble();
        String result="";
        if(point<10){
            result="Giỏi";
        }
        else if(point<8.5){
            result="Khá";
        }else if(point<6.5){
            result="Trung bình";
        }else if(point<5){
            result="Yếu";
        }else {
            System.out.println("Điểm ko hợp lệ");
        }
    }
}
