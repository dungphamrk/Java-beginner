import java.util.Scanner;
public class Ex6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên học sinh: ");
        String name=sc.nextLine();
        System.out.println("Nhập điểm môn toán: ");
        int mathScore=sc.nextInt();
        while (mathScore<0 || mathScore>10){
            mathScore=sc.nextInt();
            if (mathScore<0 || mathScore>10) {
                System.out.println("Điểm nhập môn toán ko hợp lệ,vui lòng nhập lại");
            }
        }
        System.out.println("Nhập điểm môn anh: ");
        int englishScore=sc.nextInt();
        while (englishScore<0 || englishScore>10){
            englishScore=sc.nextInt();
            if (englishScore<0 || englishScore>10) {
                System.out.println("Điểm nhập môn anh ko hợp lệ,vui lòng nhập lại");
            }
        }
        System.out.println("Nhập điểm môn Văn: ");
        int literatureScore=sc.nextInt();
        while (literatureScore<0 || literatureScore>10){
            literatureScore=sc.nextInt();
            if (literatureScore<0 || literatureScore>10) {
                System.out.println("Điểm nhập môn văn ko hợp lệ,vui lòng nhập lại");
            }
        }
        double averageScore=(mathScore+englishScore+literatureScore)/3;
        System.out.print("Name: "+name+", average score: "+averageScore+" ,");
        if(averageScore>8){
            System.out.println("rank: Giỏi");
        }else if(averageScore>6.5){
            System.out.println("rank: Khá");
        }else if(averageScore>5.0){
            System.out.println("rank: Trung Bình");
        }else {
            System.out.println("rank: Yếu");
        }
    }
}
