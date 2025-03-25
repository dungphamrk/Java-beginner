package presentation;

import entity.Student;
import manager.Mgstudent;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentManagement {
    public static Map<String, Student> students = new HashMap<>();
    public static int studentCount = 0 ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menuManager(scanner);
    }
    public static void menuManager( Scanner scanner){
        do {
            System.out.println("********************MENU*******************");
            System.out.println("1. Danh sách sinh viên");
            System.out.println("2. Thêm mới các sinh viên");
            System.out.println("3. Xóa sinh viên theo mã sinh viên");
            System.out.println("4. Tính điểm trung bình của tất cả sinh viên");
            System.out.println("5. In thông tin sinh viên có điểm trung bình lớn nhất");
            System.out.println("6. In thông tin sinh viên có tuổi nhỏ nhất");
            System.out.println("7. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    Mgstudent.displayStudents();
                    break;
                case 2:
                    Mgstudent.addStudent(scanner);
                    break;
                case 3:
                    Mgstudent.delStudent(scanner);
                    break;
                case 4:
                    Mgstudent.printAVGScore();
                    break;
                case 5:
                    Mgstudent.maxAvgScoreOfAllStudent();
                case 6:
                    Mgstudent.minAgeOfAllStudent();
                case 7:
                    return;
                default:
                    System.out.println("Vui lòng chọn từ 1 -> 7");
            }
        }while(true);
    }

}
