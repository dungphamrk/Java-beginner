import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Nhập vào một số nguyên: ");
            int number =  Integer.parseInt(scanner.nextLine());
            System.out.println("Bạn đã nhập: "+number);
        } catch (NumberFormatException e) {
            System.err.println("Lỗi: Bạn phải nhập số nguyên");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
        }
    }
}
