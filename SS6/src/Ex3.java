import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        String initialString  = "";
        String findString= "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chuỗi văn bản:");
        initialString = sc.nextLine();
        System.out.println("Nhập chuỗi vãn bản cần tìm:");
        findString = sc.nextLine();
        int result= initialString.indexOf(findString);
        if(result==-1){
            System.out.println("Không tìm thấy " + findString + " trong chuỗi");
        }else{
            System.out.printf("Từ"+findString+"xuất hiện tại vị trí thứ %d trong chuỗi",result);
        }
    }
}
