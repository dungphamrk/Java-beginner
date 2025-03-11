import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chuỗi : ");
        StringBuilder result = new StringBuilder(sc.nextLine());
        do {
            System.out.println("============MENU QUẢN LÝ CHUỖI===============");
            System.out.println("1. Đảo ngược chuỗi");
            System.out.println("2. Chèn chuỗi vào vị trí bất kỳ");
            System.out.println("3. Xóa một đoạn trong chuỗi");
            System.out.println("4. Thay thế một đoạn trong chuỗi");
            System.out.println("5. Chuyển đổi toàn bộ chuỗi thành chữ hoa / chữ thường");
            System.out.println("6. Thoát chương trình");
            System.out.println("Chọn chức năng (1 - 6) : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Chuỗi đảo ngược : " + result.reverse());
                    break;
                case 2:
                    System.out.print("Nhập vị trí cần chèn : ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nhập từ cần chèn : ");
                    String insertText = sc.nextLine();
                    result.insert(n, insertText);
                    System.out.println("Chuỗi sau khi chèn : " + result);
                    break;
                case 3:
                    System.out.print("Nhập vị trí bắt đầu xóa: ");
                    int startDel = sc.nextInt();
                    System.out.print("Nhập vị trí kết thúc xóa: ");
                    int endDel = sc.nextInt();
                    result.delete(startDel, endDel);
                    System.out.println("Chuỗi sau khi xóa : " + result);
                    break;
                case 4:
                    System.out.print("Nhập vị trí khởi đầu thay thế : ");
                    int start = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nhập vị trí kết thúc thay thế : ");
                    int end = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nhập từ để thay thế : ");
                    String textChange = sc.nextLine();
                    result.replace(start, end, textChange);
                    System.out.println("Chuỗi sau khi thay thế : " + result);
                    break;
                case 5:
                    do {
                        System.out.println("1. Đổi thành chữ thường");
                        System.out.println("2. Đổi thành chữ hoa");
                        System.out.print("Nhập lựa chọn: ");
                        choice = sc.nextInt();
                        sc.nextLine();
                        switch (choice) {
                            case 1:
                                System.out.println("Chuỗi là chữ thường: " + result.toString().toLowerCase());
                                break;
                            case 2:
                                System.out.println("Chuỗi là chữ hoa: " + result.toString().toUpperCase());
                                break;
                            default:
                                System.out.println("Vui lòng chọn 1 hoặc 2");
                                continue;
                        }
                        break;
                    } while (true);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng chọn 1 - 6");
            }
        } while (true);
    }
}
