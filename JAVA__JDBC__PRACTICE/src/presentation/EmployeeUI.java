package presentation;

import business.model.Department;
import business.model.Employee;
import business.service.employee.EmployeeService;
import business.service.employee.EmployeeServiceImp;
import validate.EmployeeValidator;
import validate.Validator;

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
        final int SIZE = 10; // Mặc định 10 bản ghi mỗi trang
        int totalEmployees = employeeService.getTotalEmployeeCount();
        int totalPages = (int) Math.ceil((double) totalEmployees / SIZE);
        int currentPage = 1;

        do {
            System.out.println("Danh sách nhân viên (Trang " + currentPage + "/" + totalPages + "):");
            List<Employee> employees = employeeService.findAllWithPaging(currentPage, SIZE);
            if (employees.isEmpty()) {
                System.err.println("Không tìm thấy nhân viên ở trang này.");
            } else {
                employees.forEach(emp -> System.out.println(emp.getEmployeeId() + " | " +
                        emp.getFullName() + " | " +
                        emp.getEmail() + " | " +
                        emp.getStatus()));
                System.out.println("Tổng số bản ghi: " + totalEmployees + " | Tổng số trang: " + totalPages);
            }

            // Menu điều hướng
            System.out.println("***************ĐIỀU HƯỚNG**************");
            System.out.println("1. Trang trước");
            System.out.println("2. Trang sau");
            System.out.println("3. Chọn trang");
            System.out.println("4. Thoát");
            int choice = Validator.validateChoice(scanner);
            switch (choice) {
                case 1: // Trang trước
                    if (currentPage > 1) {
                        currentPage--;
                    } else {
                        System.err.println("Đã ở trang đầu tiên!");
                    }
                    break;
                case 2: // Trang sau
                    if (currentPage < totalPages) {
                        currentPage++;
                    } else {
                        System.err.println("Đã ở trang cuối cùng!");
                    }
                    break;
                case 3: // Chọn trang
                    System.out.println("Nhập số trang (1-" + totalPages + "):");
                    String pageStr = scanner.nextLine();
                    if (!Validator.isValidDataType(pageStr, Integer.class)) {
                        System.err.println("Trang không hợp lệ");
                        break;
                    }
                    int page = Integer.parseInt(pageStr);
                    if (page < 1 || page > totalPages) {
                        System.err.println("Trang phải từ 1 đến " + totalPages);
                        break;
                    }
                    currentPage = page;
                    break;
                case 4: // Thoát
                    return;
                default:
                    System.err.println("Vui lòng chọn từ 1-4");
            }
        } while (true);
    }

    private static void addEmployee(Scanner scanner, EmployeeService employeeService) {
        Employee emp = new Employee();
        emp.inputData(scanner);
        int result = employeeService.save(emp);
        if (result == 1) {
            System.out.println("Thêm nhân viên thành công!");
        } else {
            System.err.println(getAddEmployeeErrorMessage(result));
        }
    }

    private static String getAddEmployeeErrorMessage(int p_result) {
        return switch (p_result) {
            case 2 -> "Phòng ban không tồn tại";
            case 3 -> "Phòng ban không hoạt động";
            case 4 -> "Mã nhân viên hoặc email đã tồn tại";
            case 5 -> "Mã nhân viên không đúng định dạng (E + 4 số)";
            case 6 -> "Tên nhân viên không đúng độ dài (15-150 ký tự)";
            case 7 -> "Email không đúng định dạng";
            case 8 -> "Số điện thoại không hợp lệ";
            case 9 -> "Bậc lương không hợp lệ";
            case 10 -> "Lương không hợp lệ";
            default -> "Lỗi không xác định khi thêm nhân viên";
        };
    }

    private static void updateEmployee(Scanner scanner, EmployeeService employeeService) {
        System.out.println("Nhập mã nhân viên cần cập nhật:");
        String employeeId = scanner.nextLine();
        if (!EmployeeValidator.isValidEmployeeId(employeeId)) {
            System.err.println("Mã nhân viên không đúng định dạng (E + 4 số)");
            return;
        }
        Employee emp = new Employee();
        emp.setEmployeeId(employeeId);
        emp.inputData(scanner); // Sử dụng inputData để nhập các trường còn lại
        int result = employeeService.update(emp);
        if (result == 1) {
            System.out.println("Cập nhật nhân viên thành công!");
        } else {
            System.err.println(getUpdateEmployeeErrorMessage(result));
        }
    }

    private static String getUpdateEmployeeErrorMessage(int p_result) {
        return switch (p_result) {
            case 2 -> "Phòng ban không tồn tại";
            case 3 -> "Phòng ban không hoạt động";
            case 4 -> "Email đã tồn tại";
            case 5 -> "Tên nhân viên không đúng độ dài (15-150 ký tự)";
            case 6 -> "Email không đúng định dạng";
            case 7 -> "Số điện thoại không hợp lệ";
            case 8 -> "Bậc lương không hợp lệ";
            case 9 -> "Lương không hợp lệ";
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
        int result = employeeService.delete(emp);
        if (result == 1) {
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