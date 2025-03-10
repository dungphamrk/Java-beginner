import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số dòng của mảng 2 chiều:");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập vào số cột của mảng 2 chiều:");
        int m = Integer.parseInt(scanner.nextLine());
        int[][] numbers = new int[n][m];
        do {
            System.out.println("1. Nhập giá trị các phần tử của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng theo ma trận");
            System.out.println("3. Tính số lượng các phần tử chia hết cho 2 và 3 trong mảng");
            System.out.println("4. In các phần tử và tổng các phần tử nằm trên đường biên, đường chéo chính và đường chéo phụ");
            System.out.println("5. Sử dụng thuật toán sắp xếp lựa chọn sắp xếp các phần tử tăng dần theo cột của mảng");
            System.out.println("6. In ra các phần tử là số nguyên tố trong mảng");
            System.out.println("7. Sử dụng thuật toán chèn (Insertion sort) sắp xếp các phần tử trên đường chéo chính của mảng giảm dần");
            System.out.println("8. Nhập giá trị một mảng 1 chiều gồm m phần tử và chỉ số dòng muốn chèn vào mảng, thực hiện chèn vào mảng 2 chiều");
            System.out.println("9. Thoát");
            System.out.print("Lựa chọn của bạn (1 - 9) : ");
            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    for (int  i = 0; i < numbers.length; i++) {
                        for (int j = 0; j < numbers[i].length; j++) {
                            System.out.printf("[%d][%d] = ",i,j);
                            numbers[i][j] = scanner.nextInt();
                        }
                    }
                    break;
                case 2:
                    for (int  i = 0; i < numbers.length; i++) {
                        for (int j = 0; j < numbers[i].length; j++) {
                            System.out.printf("%4d", numbers[i][j]);
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    int count = 0;
                    for (int  i = 0; i < numbers.length; i++) {
                        for (int j = 0; j < numbers[i].length; j++) {
                            if (numbers[i][j] %2 == 0 && numbers[i][j] %3 == 0) {
                                count++;
                            }
                        }
                    }
                    System.out.println("Số lượng các phần tử chia hết cho 2 và 3 trong mảng là : "+count);
                    break;
                case 4:
                    int sum = 0;
                    System.out.println("Các phần tử cần in:");
                    for (int i = 0; i < numbers.length; i++) {
                        for (int j = 0; j < numbers[i].length; j++) {
                            if (i == 0 || i == n - 1 || j == 0 || j == n - 1 || i == j || i + j == n - 1) {
                                System.out.printf("%4d", numbers[i][j]);
                                sum += numbers[i][j];
                            }
                        }
                        System.out.println();
                    }
                    System.out.println("Tổng các phần tử nằm trên đường biên, đường chéo : " + sum);
                    break;
                case 5:
                    for (int j = 0; j < n; j++) {
                        for (int i = 0; i < m - 1; i++) {
                            int minIndex = i;
                            for (int k = i + 1; k < m; k++) {
                                if (numbers[k][j] < numbers[minIndex][j]) {
                                    minIndex = k;
                                }
                            }
                            int temp = numbers[i][j];
                            numbers[i][j] = numbers[minIndex][j];
                            numbers[minIndex][j] = temp;
                        }
                    }

                    System.out.println("Ma trận sau khi sắp xếp theo cột:");
                    for (int i = 0; i < numbers.length; i++) {
                        for (int j = 0; j < numbers[i].length; j++) {
                            System.out.printf("%4d", numbers[i][j]);
                        }
                        System.out.println();
                    }
                    break;
                case 6:
                    for (int  i = 0; i < numbers.length; i++) {
                        for (int j = 0; j < numbers[i].length; j++) {
                            boolean isPrime = true;
                            if (numbers[i][j] % 2 == 0) {
                                isPrime = false;
                            } else {
                                for (int k = 2; k <= Math.sqrt(numbers[i][j]); k++) {
                                    if (numbers[i][j] % k == 0) {
                                        isPrime = false;
                                        break;
                                    }
                                }
                            }

                            if (isPrime) {
                                System.out.printf("Các số nguyên tố trong ma trận : %d", numbers[i][j]);
                            }
                            System.out.println();
                        }
                    }
                    break;
                case 7:
                    for (int i = 1; i < Math.min(m, n); i++) {
                        int key = numbers[i][i];
                        int j = i - 1;

                        while (j >= 0 && numbers[j][j] < key) {
                            numbers[j + 1][j + 1] = numbers[j][j];
                            j--;
                        }
                        numbers[j + 1][j + 1] = key;
                    }

                    System.out.println("Ma trận sau khi sắp xếp đường chéo chính giảm dần:");
                    for (int i = 0; i < numbers.length; i++) {
                        for (int j = 0; j < numbers[i].length; j++) {
                            System.out.printf("%4d", numbers[i][j]);
                        }
                        System.out.println();
                    }
                    break;
                case 8:
                    System.out.print("Nhập số phần tử của mảng 1 chiều: ");
                    int k = scanner.nextInt();
                    int[] array = new int[k];

                    System.out.println("Nhập các phần tử của mảng 1 chiều:");
                    for (int i = 0; i < k; i++) {
                        System.out.printf("numbers[%d] = ", i);
                        array[i] = scanner.nextInt();
                    }

                    System.out.print("Nhập chỉ số dòng muốn chèn vào : ");
                    int rowIndex = scanner.nextInt();

                    if (rowIndex < 0 || rowIndex >= n) {
                        System.out.println("Chỉ số dòng không hợp lệ.");
                    } else {
                        for (int j = 0; j < m; j++) {
                            numbers[rowIndex][j] = array[j];
                        }

                        System.out.println("Ma trận 2 chiều sau khi chèn:");
                        for (int i = 0; i < numbers.length; i++) {
                            for (int j = 0; j < numbers[i].length; j++) {
                                System.out.printf("%4d", numbers[i][j]);
                            }
                            System.out.println();
                        }
                    }
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn của bạn không hợp lệ . Vui lòng chọn 1 - 9");
            }
        }while (true);
    }
}