import java.util.Scanner;
public class BookManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] arrBooks = new Book[300];
        int currentIndex = 0;

        while (true) {
            System.out.println("****************************MENU*************************");
            System.out.println("1. Danh sách sách");
            System.out.println("2. Thêm mới sách");
            System.out.println("3. Tính lợi nhuận của các sách");
            System.out.println("4. Cập nhật sách");
            System.out.println("5. Xóa sách");
            System.out.println("6. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("7. Tìm kiếm sách theo tác giả");
            System.out.println("8. Tìm kiếm sách theo khoảng giá (giá bán)");
            System.out.println("9. Thống kê sách theo tác giả");
            System.out.println("10. Thoát");
            System.out.print("Lựa chọn (1 - 10): ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Danh sách sách:");
                    for (int i = 0; i < currentIndex; i++) {
                        arrBooks[i].displayData();
                    }
                    break;

                case 2:
                    System.out.print("Nhập số sách cần thêm: ");
                    int numBooks = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < numBooks; i++) {
                        arrBooks[currentIndex] = new Book();
                        arrBooks[currentIndex].inputData(scanner);
                        currentIndex++;
                    }
                    break;

                case 3:
                    for (int i = 0; i < currentIndex; i++) {
                        arrBooks[i].getInterest();
                    }
                    System.out.println("Đã tính lợi nhuận cho tất cả sách.");
                    break;

                case 4:
                    System.out.print("Nhập mã sách cần cập nhật: ");
                    String updateId = scanner.nextLine();
                    int indexUpdate = -1;
                    for (int i = 0; i < currentIndex; i++) {
                        if (arrBooks[i].getBookId().equals(updateId)) {
                            indexUpdate = i;
                            break;
                        }
                    }
                    if (indexUpdate == -1) {
                        System.out.println("Không tìm thấy sách với mã: " + updateId);
                    } else {
                        System.out.println("Cập nhật thông tin sách:");
                        arrBooks[indexUpdate].inputData(scanner);
                    }
                    break;

                case 5:
                    System.out.print("Nhập mã sách cần xóa: ");
                    String deleteId = scanner.nextLine();
                    int indexDelete = -1;
                    for (int i = 0; i < currentIndex; i++) {
                        if (arrBooks[i].getBookId().equals(deleteId)) {
                            indexDelete = i;
                            break;
                        }
                    }

                    if (indexDelete == -1) {
                        System.out.println("Không tìm thấy sách có mã: " + deleteId);
                    } else {
                        for (int i = indexDelete; i < currentIndex - 1; i++) {
                            arrBooks[i] = arrBooks[i + 1];
                        }
                        arrBooks[currentIndex - 1] = null;
                        currentIndex--;
                        System.out.println("Đã xóa sách thành công.");
                    }
                    break;

                case 6:
                    for (int i = 0; i < currentIndex - 1; i++) {
                        for (int j = 0; j < currentIndex - 1 - i; j++) {
                            if (arrBooks[j].getInterest() > arrBooks[j + 1].getInterest()) {
                                Book temp = arrBooks[j];
                                arrBooks[j] = arrBooks[j + 1];
                                arrBooks[j + 1] = temp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp sách theo lợi nhuận tăng dần.");
                    break;

                case 7:
                    System.out.print("Nhập tên tác giả: ");
                    String authorSearch = scanner.nextLine();
                    boolean found = false;
                    for (int i = 0; i < currentIndex; i++) {
                        if (arrBooks[i].getAuthor().equalsIgnoreCase(authorSearch)) {
                            if (!found) {
                                System.out.println("Danh sách sách của tác giả: " + authorSearch);
                                found = true;
                            }
                            arrBooks[i].displayData();
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy sách của tác giả: " + authorSearch);
                    }
                    break;

                case 8:
                    System.out.print("Nhập giá bán thấp nhất: ");
                    double minPrice = Double.parseDouble(scanner.nextLine());
                    System.out.print("Nhập giá bán cao nhất: ");
                    double maxPrice = Double.parseDouble(scanner.nextLine());
                    boolean hasBook = false;

                    System.out.println("Danh sách sách trong khoảng giá: " + minPrice + " - " + maxPrice);
                    for (int i = 0; i < currentIndex; i++) {
                        if (arrBooks[i].getExportPrice() >= minPrice && arrBooks[i].getExportPrice() <= maxPrice) {
                            arrBooks[i].displayData();
                            hasBook = true;
                        }
                    }
                    if (!hasBook) {
                        System.out.println("Không có sách nào trong khoảng giá này.");
                    }
                    break;

                case 9:
                    boolean[] printed = new boolean[currentIndex];
                    for (int i = 0; i < currentIndex; i++) {
                        if (!printed[i]) {
                            String author = arrBooks[i].getAuthor();
                            int count = 1;

                            for (int j = i + 1; j < currentIndex; j++) {
                                if (arrBooks[j].getAuthor().equals(author)) {
                                    count++;
                                    printed[j] = true;
                                }
                            }
                            System.out.println("Tác giả: " + author + " - Số sách: " + count);
                        }
                    }
                    break;

                case 10:
                    System.out.println("Thoát chương trình...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng chọn số từ 1 - 10.");
            }
        }
    }
}
