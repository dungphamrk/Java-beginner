import java.util.Scanner;
public class Ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số phần tử của mảng phần tử của mảng : ");
        int n = sc.nextInt();
        int[] numbers = new int[n];
        do {
            System.out.println("********************MENU***************************");
            System.out.println("1. Nhập giá trị 'n' phần tử của mảng ('n' nhập từ bàn phím) : ");
            System.out.println("2. In giá trị các phần tử trong mảng");
            System.out.println("3. Tính trung bình các phần tử dương (>0) trong mảng");
            System.out.println("4. In ra vị trí (chỉ số) các phần tử có giá trị bằng 'k' trong mảng ('k' nhập từ bàn phím)");
            System.out.println("5. Tính số lượng các phần tử là 'số nguyên tố' trong mảng");
            System.out.println("6. Thoát chương trình");
            System.out.print("Lựa chọn của bạn : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 0; i < n; i++) {
                        System.out.printf("numbers[%d] : ", i);
                        numbers[i] = sc.nextInt();
                    }
                    break;
                case 2:
                    System.out.println("Các phần tử trong mảng là : ");
                    for (int i = 0; i < n; i++) {
                        System.out.printf("%d\t", numbers[i]);
                    }
                    System.out.println();
                    break;
                case 3:
                    int avg = 0;
                    int sum = 0;
                    for (int i = 0; i < n; i++) {
                        if (numbers[i] > 0) {
                            sum += numbers[i];
                            avg = sum / numbers.length;
                        }
                    }
                    System.out.println("Trung bình của các phần tử dương trong mảng là : "+avg);
                    break;
                case 4:
                    System.out.println("Nhập phần tử k bất kì : ");
                    int k = sc.nextInt();
                    boolean isFlag = false;
                    for (int i = 0; i < n; i++) {
                        if (numbers[i] == k) {
                            isFlag = true;
                            System.out.println("Phần tử "+k+" xuất hiện tại vị trí "+i+"");
                        }
                    }
                    if (!isFlag) {
                        System.out.println("Phần tử "+k+" ko tìm thấy trong mảng");
                    }
                    break;
                case 5:
                    int count = 0;
                    for (int i = 0; i < n; i++) {
                        boolean isPrime = true;
                        if (numbers[i] < 2) {
                            isPrime = false;
                        }else {
                            for (int j = 2; j <= Math.sqrt(numbers[i]); j++) {
                                if (numbers[i] % j == 0) {
                                    isPrime = false;
                                    break;
                                }
                            }
                        }
                        if (isPrime) {
                            System.out.printf("%d\t", numbers[i]);
                            count ++;
                        }
                    }
                    System.out.println();
                    System.out.printf("Số lượng các phần tử là số nguyên tố trong mảng là : %d\n", count);
                    System.out.println();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng nhập lại yêu cầu 1- 6");
            }
        }while (true);
    }
}
