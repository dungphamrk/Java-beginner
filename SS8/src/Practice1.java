import java.util.Arrays;
import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int[] arr = new int[1000];
        int choice;
        int count;
        do {
            System.out.println("***********************MENU**************************");
            System.out.println("1. Nhập giá trị n phần tử của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng");
            System.out.println("3. Tính trung bình các phần tử dương (>0) trong mảng");
            System.out.println("4. In ra vị trí các phần tử có giá trị bằng k");
            System.out.println("5. Sắp xếp mảng giảm dần (Bubble Sort)");
            System.out.println("6. Đếm số lượng phần tử là số nguyên tố trong mảng");
            System.out.println("7. Sắp xếp theo yêu cầu đặc biệt");
            System.out.println("8. Chèn giá trị m vào mảng (đã sắp xếp giảm dần)");
            System.out.println("9. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.printf("vui lòng nhập số phần tử trong mảng ");
                    n = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < n; i++) {
                        System.out.printf("arr[%d] = : \n", i);
                        i = Integer.parseInt(sc.nextLine());
                    }
                    break;
                case 2:
                    for (int i = 0; i < n; i++) {
                        System.out.printf("arr[%d] = %d \n", i, arr[i]);
                    }
                    break;
                case 3:
                    int sum = 0;
                    count = 0;
                    for (int i = 0; i < n; i++) {
                        if (arr[i] > 0) {
                            sum += arr[i];
                            count++;
                        }
                    }
                    System.out.printf("Trung bình của các số dương trong mảng là : %d \n", (double) sum / count);
                    break;
                case 4:
                    int k = 0;
                    System.out.println("Chỉ số của các phần tử cso giá trị bằng k là :");
                    for (int i = 0; i < n; i++) {
                        if (arr[i] == k) {
                            System.out.println(i + " ");
                        }
                    }
                    break;
                case 5:
                    int temp = 0;
                    for (int i = 0; i < n; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (arr[i] < arr[j]) {
                                temp = arr[i];
                                arr[i] = arr[j];
                                arr[j] = temp;
                            }
                        }
                    }
                    System.out.println("Mảng sau khi được sắp xếp giảm dần là");
                    for (int i = 0; i < n; i++) {
                        System.out.println(arr[i] + " ");
                    }
                    break;
                case 6:
                    count = 0;
                    for (int i = 0; i < n; i++) {
                        boolean isPrime = true;

                        if (arr[i] <= 1) {
                            isPrime = false;
                        } else {
                            for (int j = 2; j <= Math.sqrt(arr[i]); j++) {
                                if (arr[i] % j == 0) {
                                    isPrime = false;
                                    break;
                                }
                            }
                        }

                        if (isPrime) {
                            count++;
                        }
                    }

                    System.out.println("Số lượng các số nguyên tố trong mảng là: " + count);
                    break;
                case 7:
                    int[] arr1 = new int[n];
                    int[] arr2 = new int[n];
                    int[] arr3 = new int[n];

                    int countArr1 = 0;
                    int countArr2 = 0;
                    int countArr3 = 0;

                    for (int i = 0; i < n; i++) {
                        if (arr[i] % 2 == 0 && arr[i] % 3 == 0) {
                            arr1[countArr1++] = arr[i];
                        } else if (arr[i] % 2 != 0 && arr[i] % 3 == 0) {
                            arr2[countArr2++] = arr[i];
                        } else {
                            arr3[countArr3++] = arr[i];
                        }
                    }

                    Arrays.sort(arr1, 0, countArr1);
                    Arrays.sort(arr2, 0, countArr2);
                    Arrays.sort(arr3, 0, countArr3);

                    int index = 0;

                    for (int i = 0; i < countArr1; i++) {
                        arr[index++] = arr1[i];
                    }

                    for (int i = 0; i < countArr3; i++) {
                        arr[index++] = arr3[i];
                    }

                    for (int i = countArr2 - 1; i >= 0; i--) {
                        arr[index++] = arr2[i];
                    }

                    System.out.println("Mảng sau khi sắp xếp:");
                    for (int i = 0; i < n; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    break;
                case 8:
                    System.out.println("Vui lòng nhập giá trị cần chèn:");
                    int value = Integer.parseInt(sc.nextLine());

                    System.out.println("Vui lòng nhập vị trí cần chèn:");
                    int manag = Integer.parseInt(sc.nextLine());

                    if (manag < 0 || manag > n) {
                        System.out.println("Vị trí không hợp lệ!");
                        break;
                    }

                    int[] newArr = new int[n + 1];

                    for (int i = 0; i < manag; i++) {
                        newArr[i] = arr[i];
                    }

                    newArr[manag] = value;

                    for (int i = manag + 1; i < newArr.length; i++) {
                        newArr[i] = arr[i - 1];
                    }

                    int temp1;
                    for (int i = 0; i < newArr.length - 1; i++) {
                        for (int j = i + 1; j < newArr.length; j++) {
                            if (newArr[i] > newArr[j]) {
                                temp1 = newArr[i];
                                newArr[i] = newArr[j];
                                newArr[j] = temp1;
                            }
                        }
                    }

                    System.out.println("Mảng sau khi chèn và sắp xếp:");
                    for (int i = 0; i < newArr.length; i++) {
                        System.out.print(newArr[i] + " ");
                    }
                    System.out.println();

                    break;
                case 9:
                    System.out.println("Thoát chương trình!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        } while (choice != 9);
    }
}