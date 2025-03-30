import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int[] numbers = new int[10];
            System.out.println("Nhập vào số lượng phần tử của mảng: ");
            int n = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < n; i++) {
                System.out.printf("arr[%d] = ", i);
                numbers[i] = Integer.parseInt(scanner.nextLine());
            }
            System.out.println("Nhập vào chỉ số cần lấy giá trị: ");
            int index = Integer.parseInt(scanner.nextLine());
            System.out.println("Giá trị phần tử là: " + numbers[index]);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
