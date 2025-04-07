package presentation;

import business.*;

import java.util.Scanner;

public class UniversityManager {
    private UniversityData data;
    private Scanner scanner;
    private CourseManagement courseManagement;
    private TeacherManagement teacherManagement;
    private StudentManagement studentManagement;
    private CourseRegistrationManagement courseRegistrationManagement;
    private ClassRoomManagement classRoomManagement;
    private DashboardManagement dashboardManagement;

    public UniversityManager() {
        this.data = new UniversityData();
        this.scanner = new Scanner(System.in);
        this.courseManagement = new CourseManagement(data.getCourses());
        this.teacherManagement = new TeacherManagement(data.getTeachers());
        this.studentManagement = new StudentManagement(data.getStudents());
        this.courseRegistrationManagement = new CourseRegistrationManagement(data.getRegistrations(), data.getStudents(), data.getCourses());
        this.classRoomManagement = new ClassRoomManagement(data.getClassRooms(), data.getCourses(), data.getTeachers(), data.getStudents());
        this.dashboardManagement = new DashboardManagement(data.getStudents(), data.getTeachers(), data.getCourses(), data.getClassRooms(), data.getRegistrations());
    }

    public void displayMainMenu() {
        while (true) {
            System.out.println("************************* UNIVERSITY MENU **********************");
            System.out.println("1. Quản lý khóa học");
            System.out.println("2. Quản lý giảng viên");
            System.out.println("3. Quản lý sinh viên");
            System.out.println("4. Đăng ký khóa học");
            System.out.println("5. Quản lý lớp học");
            System.out.println("6. Thống kê");
            System.out.println("7. Thoát");
            System.out.print("Chọn: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    manageCourses();
                    break;
                case "2":
                    manageTeachers();
                    break;
                case "3":
                    manageStudents();
                    break;
                case "4":
                    manageCourseRegistration();
                    break;
                case "5":
                    manageClassRooms();
                    break;
                case "6":
                    displayDashboard();
                    break;
                case "7":
                    System.out.println("Tạm biệt!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private void manageCourses() {
        while (true) {
            System.out.println("************************* COURSE MENU *************************");
            System.out.println("1. Danh sách khóa học sắp xếp theo tên tăng dần");
            System.out.println("2. Thêm mới khóa học");
            System.out.println("3. Cập nhật khóa học");
            System.out.println("4. Xóa khóa học theo ID");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    courseManagement.listCourses();
                    break;
                case "2":
                    courseManagement.addCourse(scanner);
                    break;
                case "3":
                    courseManagement.updateCourse(scanner);
                    break;
                case "4":
                    courseManagement.deleteCourse(scanner);
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private void manageTeachers() {
        while (true) {
            System.out.println("************************* TEACHER MENU *************************");
            System.out.println("1. Danh sách giảng viên sắp xếp theo mã giảm dần");
            System.out.println("2. Thêm mới giảng viên");
            System.out.println("3. Cập nhật giảng viên");
            System.out.println("4. Xóa giảng viên");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    teacherManagement.listTeachers();
                    break;
                case "2":
                    teacherManagement.addTeacher(scanner);
                    break;
                case "3":
                    teacherManagement.updateTeacher(scanner);
                    break;
                case "4":
                    teacherManagement.deleteTeacher(scanner);
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private void manageStudents() {
        while (true) {
            System.out.println("************************* STUDENT MENU *************************");
            System.out.println("1. Danh sách sinh viên sắp xếp theo tên tăng dần");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Cập nhật sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    studentManagement.listStudents();
                    break;
                case "2":
                    studentManagement.addStudent(scanner);
                    break;
                case "3":
                    studentManagement.updateStudent(scanner);
                    break;
                case "4":
                    studentManagement.deleteStudent(scanner);
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private void manageCourseRegistration() {
        while (true) {
            System.out.println("******************* COURSE REGISTRATION MENU *****************");
            System.out.println("1. Đăng ký khóa học cho sinh viên");
            System.out.println("2. Hủy đăng ký học cho sinh viên");
            System.out.println("3. Duyệt đăng ký học sinh viên");
            System.out.println("4. Xem danh sách sinh viên đăng ký từ từng khóa học");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    courseRegistrationManagement.registerCourse(scanner);
                    break;
                case "2":
                    courseRegistrationManagement.cancelRegistration(scanner);
                    break;
                case "3":
                    courseRegistrationManagement.approveRegistration(scanner);
                    break;
                case "4":
                    courseRegistrationManagement.listRegistrationsByCourse(scanner);
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private void manageClassRooms() {
        while (true) {
            System.out.println("********************** CLASS ROOM MENU **********************");
            System.out.println("1. Danh sách lớp học sắp xếp theo ngày tạo giảm dần");
            System.out.println("2. Thêm mới lớp học");
            System.out.println("3. Cập nhật thông tin lớp học");
            System.out.println("4. Xóa lớp học");
            System.out.println("5. Phân công giảng viên cho lớp");
            System.out.println("6. Thêm sinh viên vào lớp");
            System.out.println("7. Tạo lịch học cho lớp");
            System.out.println("8. Cập nhật trạng thái lớp");
            System.out.println("9. Thoát");
            System.out.print("Chọn: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    classRoomManagement.listClassRooms();
                    break;
                case "2":
                    classRoomManagement.addClassRoom(scanner);
                    break;
                case "3":
                    classRoomManagement.updateClassRoom(scanner);
                    break;
                case "4":
                    classRoomManagement.deleteClassRoom(scanner);
                    break;
                case "5":
                    classRoomManagement.assignTeacher(scanner);
                    break;
                case "6":
                    classRoomManagement.addStudentToClass(scanner);
                    break;
                case "7":
                    System.out.println("Chức năng tạo lịch học chưa được triển khai!");
                    break;
                case "8":
                    classRoomManagement.updateClassStatus(scanner);
                    break;
                case "9":
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private void displayDashboard() {
        while (true) {
            System.out.println("************************** DASHBOARD ***********************");
            System.out.println("1. Thống kê số sinh viên, giảng viên, khóa học, lớp học");
            System.out.println("2. Top 3 khóa học có nhiều sinh viên nhất");
            System.out.println("3. Top 3 lớp học có nhiều sinh viên nhất");
            System.out.println("4. Top 3 giảng viên dạy nhiều sinh viên nhất");
            System.out.println("5. Top 3 sinh viên đăng ký học nhiều nhất");
            System.out.println("6. Thoát");
            System.out.print("Chọn: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    dashboardManagement.showStats();
                    break;
                case "2":
                    dashboardManagement.top3Courses();
                    break;
                case "3":
                    dashboardManagement.top3ClassRooms();
                    break;
                case "4":
                    dashboardManagement.top3Teachers();
                    break;
                case "5":
                    dashboardManagement.top3Students();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public static void main(String[] args) {
        UniversityManager manager = new UniversityManager();
        manager.displayMainMenu();
    }
}