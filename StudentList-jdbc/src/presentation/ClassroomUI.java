package presentation;

import business.model.ClassRoom;
import business.model.Student;
import business.service.classroom.ClassroomServiceImp;
import java.util.List;
import java.util.Scanner;

public class ClassroomUI {
    private final ClassroomServiceImp classroomService;

    public ClassroomUI() {
        classroomService = new ClassroomServiceImp();
    }

    public static void displayClassroomMenu(Scanner scanner) {
        ClassroomUI classroomUI = new ClassroomUI();
        do {
            System.out.println("***************CLASSROOM MANAGEMENT****************");
            System.out.println("1. Danh sách lớp học");
            System.out.println("2. Thêm mới lớp học");
            System.out.println("3. Cập nhật thông tin lớp học");
            System.out.println("4. Xóa lớp học");
            System.out.println("5. Xem danh sách học sinh trong lớp");
            System.out.println("6. Thống kê học sinh theo độ tuổi");
            System.out.println("7. Thống kê học sinh theo trạng thái");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    classroomUI.displayListClassrooms();
                    break;
                case 2:
                    classroomUI.createClassroom(scanner);
                    break;
                case 3:
                    classroomUI.updateClassroom(scanner);
                    break;
                case 4:
                    classroomUI.deleteClassroom(scanner);
                    break;
                case 5:
                    classroomUI.displayStudentsInClassroom(scanner);
                    break;
                case 6:
                    classroomUI.countStudentsByAgeRange(scanner);
                    break;
                case 7:
                    classroomUI.countStudentsByStatus(scanner);
                    break;
                case 8:
                    System.out.println("Quay lại menu chính");
                    return;
                default:
                    System.err.println("Vui lòng chọn từ 1-8");
            }
        } while (true);
    }

    public void displayListClassrooms() {
        List<ClassRoom> listClassrooms = classroomService.findAll();
        if (listClassrooms.isEmpty()) {
            System.out.println("Chưa có lớp học nào.");
        } else {
            listClassrooms.forEach(System.out::println);
        }
    }

    public void createClassroom(Scanner scanner) {
        ClassRoom classroom = new ClassRoom();
        classroom.inputData(scanner);
        boolean result = classroomService.save(classroom);
        if (result) {
            System.out.println("Thêm mới lớp học thành công");
        } else {
            System.err.println("Có lỗi trong quá trình thêm mới");
        }
    }

    public void updateClassroom(Scanner scanner) {
        System.out.println("Nhập vào mã lớp học cần cập nhật:");
        int classroomId = Integer.parseInt(scanner.nextLine());
        ClassRoom existingClassroom = classroomService.findById(classroomId);
        if (existingClassroom != null) {
            ClassRoom classroom = new ClassRoom();
            classroom.setId(classroomId);
            classroom.inputData(scanner);
            boolean result = classroomService.update(classroom);
            if (result) {
                System.out.println("Cập nhật thành công");
            } else {
                System.err.println("Có lỗi trong quá trình cập nhật");
            }
        } else {
            System.err.println("Không tồn tại mã lớp học");
        }
    }

    public void deleteClassroom(Scanner scanner) {
        System.out.println("Nhập mã lớp học cần xóa:");
        int classroomId = Integer.parseInt(scanner.nextLine());
        if (classroomService.findById(classroomId) != null) {
            ClassRoom classroom = new ClassRoom();
            classroom.setId(classroomId);
            boolean result = classroomService.delete(classroom);
            if (result) {
                System.out.println("Xóa lớp học thành công");
            } else {
                System.err.println("Có lỗi trong quá trình xóa");
            }
        } else {
            System.err.println("Mã lớp học không tồn tại");
        }
    }

    public void displayStudentsInClassroom(Scanner scanner) {
        System.out.println("Nhập mã lớp học để xem danh sách học sinh:");
        int classroomId = Integer.parseInt(scanner.nextLine());
        ClassRoom classroom = classroomService.findById(classroomId);
        if (classroom != null) {
            List<Student> students = classroomService.getStudentsInClassroom(classroomId);
            if (students.isEmpty()) {
                System.out.println("Chưa có học sinh nào trong lớp này.");
            } else {
                System.out.println("Danh sách học sinh trong lớp " + classroom.getName() + ":");
                students.forEach(System.out::println);
            }
        } else {
            System.err.println("Mã lớp học không tồn tại");
        }
    }

    public void countStudentsByAgeRange(Scanner scanner) {
        System.out.println("Nhập mã lớp học để thống kê:");
        int classroomId = Integer.parseInt(scanner.nextLine());
        if (classroomService.findById(classroomId) != null) {
            System.out.println("Nhập độ tuổi tối thiểu:");
            int minAge = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập độ tuổi tối đa:");
            int maxAge = Integer.parseInt(scanner.nextLine());
            int count = classroomService.countStudentsByAgeRange(classroomId, minAge, maxAge);
            System.out.printf("Số học sinh trong độ tuổi từ %d đến %d: %d\n", minAge, maxAge, count);
        } else {
            System.err.println("Mã lớp học không tồn tại");
        }
    }

    public void countStudentsByStatus(Scanner scanner) {
        System.out.println("Nhập mã lớp học để thống kê:");
        int classroomId = Integer.parseInt(scanner.nextLine());
        if (classroomService.findById(classroomId) != null) {
            System.out.println("Nhập trạng thái cầnCharacterCount cần thống kê (true/false):");
            boolean status = Boolean.parseBoolean(scanner.nextLine());
            int count = classroomService.countStudentsByStatus(classroomId, status);
            System.out.printf("Số học sinh có trạng thái %b trong lớp: %d\n", status, count);
        } else {
            System.err.println("Mã lớp học không tồn tại");
        }
    }
}