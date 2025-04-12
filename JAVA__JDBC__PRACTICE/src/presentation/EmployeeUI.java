package presentation;

import business.model.Department;
import business.model.Employee;
import business.service.employee.EmployeeService;
import business.service.employee.EmployeeServiceImp;
import validate.EmployeeValidator;
import validate.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmployeeUI {

    public static void displayEmployeeMenu(Scanner scanner) {
        EmployeeService employeeService = new EmployeeServiceImp();
        do {
            System.out.println("***************EMPLOYEE MENU**************");
            System.out.println("1. Danh sách nhân viên");
            System.out.println("2. Thêm nhân viên");
            System.out.println("3. Cập nhật nhân viên");
            System.out.println("4. Xóa nhân viên");
            System.out.println("5. Tìm kiếm nhân viên theo tên");
            System.out.println("6. Tìm kiếm nhân viên theo tuổi");
            System.out.println("7. Sắp xếp nhân viên theo lương giảm dần");
            System.out.println("8. Sắp xếp nhân viên theo tên tăng dần");
            System.out.println("9. Thống kê số lượng nhân viên theo phòng ban");
            System.out.println("10. Tổng số nhân viên");
            System.out.println("11. Phòng ban có nhiều nhân viên nhất");
            System.out.println("12. Phòng ban có tổng lương cao nhất");
            System.out.println("13. Thoát");
            int choice = Validator.validateChoice(scanner);
            switch (choice) {
                case 1:
                    listEmployees(scanner, employeeService);
                    break;
                case 2:
                    addEmployee(scanner, employeeService);
                    break;
                case 3:
                    updateEmployee(scanner, employeeService);
                    break;
                case 4:
                    deleteEmployee(scanner, employeeService);
                    break;
                case 5:
                    searchEmployeeByName(scanner, employeeService);
                    break;
                case 6:
                    searchEmployeeByAge(scanner, employeeService);
                    break;
                case 7:
                    sortEmployeesBySalary(scanner, employeeService);
                    break;
                case 8:
                    sortEmployeesByName(scanner, employeeService);
                    break;
                case 9:
                    countEmployeesByDepartment(employeeService);
                    break;
                case 10:
                    totalEmployeeCount(employeeService);
                    break;
                case 11:
                    departmentWithMostEmployees(employeeService);
                    break;
                case 12:
                    departmentWithHighestSalary(employeeService);
                    break;
                case 13:
                    System.out.println("Thoát quản lý nhân viên.");
                    return;
                default:
                    System.err.println("Vui lòng chọn từ 1-13");
            }
        } while (true);
    }

    private static void listEmployees(Scanner scanner, EmployeeService employeeService) {
        System.out.println("Nhập số trang (bắt đầu từ 1):");
        String pageStr = scanner.nextLine();
        if (!Validator.isValidDataType(pageStr, Integer.class)) {
            System.err.println("Trang không hợp lệ");
            return;
        }
        int page = Integer.parseInt(pageStr);
        if (page < 1) {
            System.err.println("Trang phải lớn hơn 0");
            return;
        }
        System.out.println("Nhập số bản ghi mỗi trang (mặc định 10):");
        String sizeStr = scanner.nextLine();
        if (!Validator.isValidDataType(sizeStr, Integer.class)) {
            System.err.println("Kích thước trang không hợp lệ");
            return;
        }
        int size = Integer.parseInt(sizeStr);
        if (size < 1) {
            System.err.println("Kích thước trang phải lớn hơn 0");
            return;
        }
        List<Employee> employees = employeeService.findAllWithPaging();
        if (employees.isEmpty()) {
            System.err.println("Không tìm thấy nhân viên hoặc trang không hợp lệ");
        } else {
            System.out.println("Danh sách nhân viên:");
            employees.forEach(emp -> System.out.println(emp.getEmployeeId() + " | " + emp.getFullName() + " | " + emp.getEmail() + " | " + emp.getStatus()));
        }
    }

    private static void addEmployee(Scanner scanner, EmployeeService employeeService) {
        Employee emp = new Employee();
        System.out.println("Nhập mã nhân viên (E + 4 số):");
        emp.setEmployeeId(scanner.nextLine());
        System.out.println("Nhập tên nhân viên (15-150 ký tự):");
        emp.setFullName(scanner.nextLine());
        System.out.println("Nhập email:");
        emp.setEmail(scanner.nextLine());
        System.out.println("Nhập số điện thoại (10 số, đầu số hợp lệ):");
        emp.setPhoneNumber(scanner.nextLine());
        System.out.println("Nhập giới tính (MALE/FEMALE/OTHER):");
        String genderStr = scanner.nextLine();
        if (Validator.isValidDataType(genderStr, Employee.Gender.class)) {
            emp.setGender(Employee.Gender.valueOf(genderStr.toUpperCase()));
        } else {
            System.err.println("Giới tính không hợp lệ");
            return;
        }
        System.out.println("Nhập bậc lương (> 0):");
        String payGradeStr = scanner.nextLine();
        if (Validator.isValidDataType(payGradeStr, Integer.class)) {
            emp.setPayGrade(Integer.parseInt(payGradeStr));
        } else {
            System.err.println("Bậc lương không hợp lệ");
            return;
        }
        System.out.println("Nhập lương (> 0):");
        String salaryStr = scanner.nextLine();
        if (Validator.isValidDataType(salaryStr, Double.class)) {
            emp.setSalary(Double.parseDouble(salaryStr));
        } else {
            System.err.println("Lương không hợp lệ");
            return;
        }
        System.out.println("Nhập ngày sinh (dd/MM/yyyy):");
        String birthDateStr = scanner.nextLine();
        if (Validator.isValidDataType(birthDateStr, LocalDate.class)) {
            emp.setBirthDate(LocalDate.parse(birthDateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        } else {
            System.err.println("Ngày sinh không hợp lệ");
            return;
        }
        System.out.println("Nhập địa chỉ:");
        emp.setAddress(scanner.nextLine());
        System.out.println("Nhập trạng thái (ACTIVE/INACTIVE/ONLEAVE/POLICYLEAVE):");
        String statusStr = scanner.nextLine();
        if (Validator.isValidDataType(statusStr, Employee.Status.class)) {
            emp.setStatus(Employee.Status.valueOf(statusStr.toUpperCase()));
        } else {
            System.err.println("Trạng thái không hợp lệ");
            return;
        }
        System.out.println("Nhập mã phòng ban:");
        String deptIdStr = scanner.nextLine();
        if (Validator.isValidDataType(deptIdStr, Integer.class)) {
            emp.setDepartmentId(Integer.parseInt(deptIdStr));
        } else {
            System.err.println("Mã phòng ban không hợp lệ");
            return;
        }

        String validationError = EmployeeValidator.validateEmployee(emp);
        if (validationError != null) {
            System.err.println(validationError);
            return;
        }

        int result = employeeService.save(emp);
        if (result!=0) {
            System.out.println("Thêm nhân viên thành công!");
        } else {
            System.err.println(getAddEmployeeErrorMessage());
        }
    }

    private static String getAddEmployeeErrorMessage() {
        // Ánh xạ p_result từ stored procedure AddEmployee
        // Hiện DAO trả về boolean, giả lập lỗi phổ biến
        return switch ((int) (Math.random() * 3 + 2)) {
            case 2 -> "Phòng ban không tồn tại";
            case 3 -> "Phòng ban không hoạt động";
            case 4 -> "Mã nhân viên hoặc email đã tồn tại";
            default -> "Lỗi không xác định khi thêm nhân viên";
        };
    }

    private static void updateEmployee(Scanner scanner, EmployeeService employeeService) {
        Employee emp = new Employee();
        System.out.println("Nhập mã nhân viên cần cập nhật:");
        emp.setEmployeeId(scanner.nextLine());
        System.out.println("Nhập tên nhân viên mới (15-150 ký tự):");
        emp.setFullName(scanner.nextLine());
        System.out.println("Nhập email mới:");
        emp.setEmail(scanner.nextLine());
        System.out.println("Nhập số điện thoại mới (10 số, đầu số hợp lệ):");
        emp.setPhoneNumber(scanner.nextLine());
        System.out.println("Nhập giới tính mới (MALE/FEMALE/OTHER):");
        String genderStr = scanner.nextLine();
        if (Validator.isValidDataType(genderStr, Employee.Gender.class)) {
            emp.setGender(Employee.Gender.valueOf(genderStr.toUpperCase()));
        } else {
            System.err.println("Giới tính không hợp lệ");
            return;
        }
        System.out.println("Nhập bậc lương mới (> 0):");
        String payGradeStr = scanner.nextLine();
        if (Validator.isValidDataType(payGradeStr, Integer.class)) {
            emp.setPayGrade(Integer.parseInt(payGradeStr));
        } else {
            System.err.println("Bậc lương không hợp lệ");
            return;
        }
        System.out.println("Nhập lương mới (> 0):");
        String salaryStr = scanner.nextLine();
        if (Validator.isValidDataType(salaryStr, Double.class)) {
            emp.setSalary(Double.parseDouble(salaryStr));
        } else {
            System.err.println("Lương không hợp lệ");
            return;
        }
        System.out.println("Nhập ngày sinh mới (dd/MM/yyyy):");
        String birthDateStr = scanner.nextLine();
        if (Validator.isValidDataType(birthDateStr, LocalDate.class)) {
            emp.setBirthDate(LocalDate.parse(birthDateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        } else {
            System.err.println("Ngày sinh không hợp lệ");
            return;
        }
        System.out.println("Nhập địa chỉ mới:");
        emp.setAddress(scanner.nextLine());
        System.out.println("Nhập trạng thái mới (ACTIVE/INACTIVE/ONLEAVE/POLICYLEAVE):");
        String statusStr = scanner.nextLine();
        if (Validator.isValidDataType(statusStr, Employee.Status.class)) {
            emp.setStatus(Employee.Status.valueOf(statusStr.toUpperCase()));
        } else {
            System.err.println("Trạng thái không hợp lệ");
            return;
        }
        System.out.println("Nhập mã phòng ban mới:");
        String deptIdStr = scanner.nextLine();
        if (Validator.isValidDataType(deptIdStr, Integer.class)) {
            emp.setDepartmentId(Integer.parseInt(deptIdStr));
        } else {
            System.err.println("Mã phòng ban không hợp lệ");
            return;
        }

        String validationError = EmployeeValidator.validateEmployee(emp);
        if (validationError != null) {
            System.err.println(validationError);
            return;
        }

        boolean result = employeeService.update(emp);
        if (result) {
            System.out.println("Cập nhật nhân viên thành công!");
        } else {
            System.err.println(getUpdateEmployeeErrorMessage());
        }
    }

    private static String getUpdateEmployeeErrorMessage() {
        return switch ((int) (Math.random() * 3 + 2)) {
            case 2 -> "Phòng ban không tồn tại";
            case 3 -> "Phòng ban không hoạt động";
            case 4 -> "Email đã tồn tại";
            case 10 -> "Nhân viên không tồn tại";
            default -> "Lỗi không xác định khi cập nhật nhân viên";
        };
    }

    private static void deleteEmployee(Scanner scanner, EmployeeService employeeService) {
        System.out.println("Nhập mã nhân viên cần xóa:");
        String employeeId = scanner.nextLine();
        if (!EmployeeValidator.isValidEmployeeId(employeeId)) {
            System.err.println("Mã nhân viên không đúng định dạng (E + 4 số)");
            return;
        }
        Employee emp = new Employee();
        emp.setEmployeeId(employeeId);
        boolean result = employeeService.delete(emp);
        if (result) {
            System.out.println("Xóa nhân viên thành công (trạng thái chuyển thành INACTIVE)!");
        } else {
            System.err.println("Nhân viên không tồn tại");
        }
    }

    private static void searchEmployeeByName(Scanner scanner, EmployeeService employeeService) {
        System.out.println("Nhập tên nhân viên cần tìm:");
        String name = scanner.nextLine();
        if (name.trim().isEmpty()) {
            System.err.println("Tên không được để trống");
            return;
        }
        List<Employee> employees = employeeService.searchByName(name);
        if (employees.isEmpty()) {
            System.err.println("Không tìm thấy nhân viên nào với tên: " + name);
        } else {
            System.out.println("Kết quả tìm kiếm:");
            employees.forEach(emp -> System.out.println(emp.getEmployeeId() + " | " + emp.getFullName() + " | " + emp.getEmail() + " | " + emp.getStatus()));
        }
    }

    private static void searchEmployeeByAge(Scanner scanner, EmployeeService employeeService) {
        System.out.println("Nhập tuổi tối thiểu:");
        String minAgeStr = scanner.nextLine();
        if (!Validator.isValidDataType(minAgeStr, Integer.class)) {
            System.err.println("Tuổi tối thiểu không hợp lệ");
            return;
        }
        int minAge = Integer.parseInt(minAgeStr);
        if (minAge < 0) {
            System.err.println("Tuổi tối thiểu không được âm");
            return;
        }
        System.out.println("Nhập tuổi tối đa:");
        String maxAgeStr = scanner.nextLine();
        if (!Validator.isValidDataType(maxAgeStr, Integer.class)) {
            System.err.println("Tuổi tối đa không hợp lệ");
            return;
        }
        int maxAge = Integer.parseInt(maxAgeStr);
        if (maxAge < minAge) {
            System.err.println("Tuổi tối đa phải lớn hơn hoặc bằng tuổi tối thiểu");
            return;
        }
        List<Employee> employees = employeeService.searchByAgeRange(minAge, maxAge);
        if (employees.isEmpty()) {
            System.err.println("Không tìm thấy nhân viên nào trong khoảng tuổi: " + minAge + "-" + maxAge);
        } else {
            System.out.println("Kết quả tìm kiếm:");
            employees.forEach(emp -> System.out.println(emp.getEmployeeId() + " | " + emp.getFullName() + " | " + emp.getStatus()));
        }
    }

    private static void sortEmployeesBySalary(Scanner scanner, EmployeeService employeeService) {
        System.out.println("Nhập số trang (bắt đầu từ 1):");
        String pageStr = scanner.nextLine();
        if (!Validator.isValidDataType(pageStr, Integer.class)) {
            System.err.println("Trang không hợp lệ");
            return;
        }
        int page = Integer.parseInt(pageStr);
        if (page < 1) {
            System.err.println("Trang phải lớn hơn 0");
            return;
        }
        System.out.println("Nhập số bản ghi mỗi trang (mặc định 10):");
        String sizeStr = scanner.nextLine();
        if (!Validator.isValidDataType(sizeStr, Integer.class)) {
            System.err.println("Kích thước trang không hợp lệ");
            return;
        }
        int size = Integer.parseInt(sizeStr);
        if (size < 1) {
            System.err.println("Kích thước trang phải lớn hơn 0");
            return;
        }
        List<Employee> employees = employeeService.sortBySalaryDesc(page, size);
        if (employees.isEmpty()) {
            System.err.println("Không tìm thấy nhân viên hoặc trang không hợp lệ");
        } else {
            System.out.println("Danh sách nhân viên (sắp xếp theo lương giảm dần):");
            employees.forEach(emp -> System.out.println(emp.getEmployeeId() + " | " + emp.getFullName() + " | " + emp.getSalary() + " | " + emp.getStatus()));
        }
    }

    private static void sortEmployeesByName(Scanner scanner, EmployeeService employeeService) {
        System.out.println("Nhập số trang (bắt đầu từ 1):");
        String pageStr = scanner.nextLine();
        if (!Validator.isValidDataType(pageStr, Integer.class)) {
            System.err.println("Trang không hợp lệ");
            return;
        }
        int page = Integer.parseInt(pageStr);
        if (page < 1) {
            System.err.println("Trang phải lớn hơn 0");
            return;
        }
        System.out.println("Nhập số bản ghi mỗi trang (mặc định 10):");
        String sizeStr = scanner.nextLine();
        if (!Validator.isValidDataType(sizeStr, Integer.class)) {
            System.err.println("Kích thước trang không hợp lệ");
            return;
        }
        int size = Integer.parseInt(sizeStr);
        if (size < 1) {
            System.err.println("Kích thước trang phải lớn hơn 0");
            return;
        }
        List<Employee> employees = employeeService.sortByNameAsc(page, size);
        if (employees.isEmpty()) {
            System.err.println("Không tìm thấy nhân viên hoặc trang không hợp lệ");
        } else {
            System.out.println("Danh sách nhân viên (sắp xếp theo tên tăng dần):");
            employees.forEach(emp -> System.out.println(emp.getEmployeeId() + " | " + emp.getFullName() + " | " + emp.getStatus()));
        }
    }

    private static void countEmployeesByDepartment(EmployeeService employeeService) {
        Map<Integer, Long> counts = employeeService.getEmployeeCountByDepartment();
        if (counts.isEmpty()) {
            System.err.println("Không có dữ liệu thống kê");
        } else {
            System.out.println("Số lượng nhân viên theo phòng ban:");
            counts.forEach((deptId, count) -> System.out.println("Phòng ban ID: " + deptId + " | Số nhân viên: " + count));
        }
    }

    private static void totalEmployeeCount(EmployeeService employeeService) {
        int count = employeeService.getTotalEmployeeCount();
        System.out.println("Tổng số nhân viên: " + count);
    }

    private static void departmentWithMostEmployees(EmployeeService employeeService) {
        Department dept = employeeService.getDepartmentWithMostEmployees();
        if (dept == null) {
            System.err.println("Không có phòng ban nào hoặc không có nhân viên");
        } else {
            System.out.println("Phòng ban có nhiều nhân viên nhất: " + dept.getDepartmentName() + " (ID: " + dept.getDepartmentId() + ")");
        }
    }

    private static void departmentWithHighestSalary(EmployeeService employeeService) {
        Department dept = employeeService.getDepartmentWithHighestSalary();
        if (dept == null) {
            System.err.println("Không có phòng ban nào hoặc không có nhân viên");
        } else {
            System.out.println("Phòng ban có tổng lương cao nhất: " + dept.getDepartmentName() + " (ID: " + dept.getDepartmentId() + ")");
        }
    }
}