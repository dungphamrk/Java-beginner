import java.util.Scanner;
public class Ex6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("***********************MAIN MENU**************************");
            System.out.println("1. Xử lí chuỗi");
            System.out.println("2. Xử lí số nguyên");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    int strChoice;
                    String str = "";
                    do {
                        System.out.println("***********************STR MENU**************************");
                        System.out.println("1. Nhập chuỗi");
                        System.out.println("2. Loại khoảng trắng thừa");
                        System.out.println("3. Đếm số lần xuất hiện của từng ký tự");
                        System.out.println("4. Chuyển đổi chuỗi thành dạng chuẩn (viết hoa chữ cái đầu mỗi từ)");
                        System.out.println("5. Thoát");
                        System.out.print("Chọn: ");
                        strChoice = sc.nextInt();
                        sc.nextLine();
                        switch (strChoice) {
                            case 1:
                                System.out.print("Nhập chuỗi: ");
                                str = sc.nextLine();
                                break;
                            case 2:
                                if (str.isEmpty()) {
                                    System.out.println("Vui lòng nhập chuỗi trước.");
                                } else {
                                    str = str.replaceAll("\\s+", " ").trim();
                                    System.out.println("Chuỗi sau khi loại khoảng trắng thừa: " + str);
                                }
                                break;
                            case 3:
                                if (str.isEmpty()) {
                                    System.out.println("Vui lòng nhập chuỗi trước.");
                                } else {
                                    int[] freq = new int[256];
                                    for (char ch : str.toCharArray()) {
                                        freq[ch]++;
                                    }
                                    System.out.println("Số lần xuất hiện của từng ký tự:");
                                    for (int i = 0; i < 256; i++) {
                                        if (freq[i] > 0) {
                                            System.out.println("'" + (char) i + "': " + freq[i] + " lần");
                                        }
                                    }
                                }
                                break;
                            case 4:
                                if (str.isEmpty()) {
                                    System.out.println("Vui lòng nhập chuỗi trước.");
                                } else {
                                    str = str.toLowerCase().trim();
                                    String[] words = str.split("\\s+");
                                    String result = "";
                                    for (String word : words) {
                                        if (!word.isEmpty()) {
                                            result += Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ";
                                        }
                                    }
                                    str = result.trim(); // Cập nhật lại str
                                    System.out.println("Chuỗi chuẩn hóa: " + str);
                                }
                                break;
                            case 5:
                                System.out.println("Thoát STR MENU");
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ");
                                break;
                        }
                    } while (strChoice != 5);
                    break;

                case 2:
                    int numChoice;
                    int n = 0;
                    int[] arr = new int[100];
                    do {
                        System.out.println("***********************NUM MENU**************************");
                        System.out.println("1. Nhập mảng số nguyên");
                        System.out.println("2. Tìm số nguyên tố lớn nhất trong mảng");
                        System.out.println("3. Đếm số phần tử có chữ số đầu tiên là số lẻ");
                        System.out.println("4. Kiểm tra xem mảng có phải đối xứng không");
                        System.out.println("5. Thoát");
                        System.out.print("Chọn: ");
                        numChoice = sc.nextInt();

                        switch (numChoice) {
                            case 1:
                                System.out.print("Nhập số phần tử của mảng: ");
                                n = sc.nextInt();
                                System.out.println("Nhập các phần tử:");
                                for (int i = 0; i < n; i++) {
                                    System.out.print("arr[" + i + "] = ");
                                    arr[i] = sc.nextInt();
                                }
                                break;

                            case 2:
                                if (n == 0) {
                                    System.out.println("Vui lòng nhập mảng trước.");
                                    break;
                                }
                                int maxPrime = Integer.MIN_VALUE;
                                for (int i = 0; i < n; i++) {
                                    int number = arr[i];
                                    boolean isPrime = true;
                                    if (number < 2) {
                                        isPrime = false;
                                    } else {
                                        for (int j = 2; j <= Math.sqrt(number); j++) {
                                            if (number % j == 0) {
                                                isPrime = false;
                                                break;
                                            }
                                        }
                                    }
                                    if (isPrime && number > maxPrime) {
                                        maxPrime = number;
                                    }
                                }
                                if (maxPrime != Integer.MIN_VALUE) {
                                    System.out.println("Số nguyên tố lớn nhất trong mảng: " + maxPrime);
                                } else {
                                    System.out.println("Không có số nguyên tố trong mảng");
                                }
                                break;

                            case 3:
                                if (n == 0) {
                                    System.out.println("Vui lòng nhập mảng trước.");
                                    break;
                                }
                                int countOddFirstDigit = 0;
                                for (int i = 0; i < n; i++) {
                                    int number = Math.abs(arr[i]);
                                    while (number >= 10) {
                                        number /= 10;
                                    }
                                    if (number % 2 == 1) {
                                        countOddFirstDigit++;
                                    }
                                }
                                System.out.println("Số phần tử có chữ số đầu tiên là số lẻ: " + countOddFirstDigit);
                                break;

                            case 4:
                                if (n == 0) {
                                    System.out.println("Vui lòng nhập mảng trước.");
                                    break;
                                }
                                boolean isSymmetric = true;
                                for (int i = 0; i < n / 2; i++) {
                                    if (arr[i] != arr[n - 1 - i]) {
                                        isSymmetric = false;
                                        break;
                                    }
                                }
                                if (isSymmetric) {
                                    System.out.println("Mảng đối xứng.");
                                } else {
                                    System.out.println("Mảng không đối xứng.");
                                }
                                break;

                            case 5:
                                System.out.println("Thoát MENU");
                                break;

                            default:
                                System.out.println("Lựa chọn không hợp lệ");
                                break;
                        }
                    } while (numChoice != 5);
                    break;

                case 3:
                    System.out.println("Thoát chương trình chính");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }

        } while (choice != 3);

        sc.close();
    }
}