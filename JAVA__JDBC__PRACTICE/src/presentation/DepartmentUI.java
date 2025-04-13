package presentation;

import business.model.Department;
import business.service.department.DepartmentService;
import business.service.department.DepartmentServiceImp;
import validate.DepartmentValidator;
import validate.Validator;

import java.util.List;
import java.util.Scanner;

public class DepartmentUI {

    public static void displayDepartmentMenu(Scanner scanner) {
        DepartmentService departmentService = new DepartmentServiceImp();
        do {
            System.out.println("***************DEPARTMENT MENU**************");
            System.out.println("1. Danh sách phòng ban");
            System.out.println("2. Thêm phòng ban");
            System.out.println("3. Cập nhật phòng ban");
            System.out.println("4. Xóa phòng ban");
            System.out.println("5. Tìm kiếm phòng ban theo tên");
            System.out.println("6. Thoát");
            int choice = Validator.validateChoice(scanner);
            switch (choice) {
                case 1:
                    listDepartments(scanner, departmentService);
                    break;
                case 2:
                    addDepartment(scanner, departmentService);
                    break;
                case 3:
                    updateDepartment(scanner, departmentService);
                    break;
                case 4:
                    deleteDepartment(scanner, departmentService);
                    break;
                case 5:
                    searchDepartmentByName(scanner, departmentService);
                    break;
                case 6:
                    System.out.println("Thoát quản lý phòng ban.");
                    return;
                default:
                    System.err.println("Vui lòng chọn từ 1-6");
            }
        } while (true);
    }

    private static void listDepartments(Scanner scanner, DepartmentService departmentService) {
        final int SIZE = 5; // Mặc định 5 bản ghi mỗi trang
        int currentPage = 1;

        do {
            List<Department> departments = departmentService.findAllWithPaging(currentPage, SIZE);
            int totalDepartments = departments.size(); // Giả định không có API lấy tổng số phòng ban
            int totalPages = (int) Math.ceil((double) totalDepartments / SIZE);

            System.out.println("Danh sách phòng ban (Trang " + currentPage + "/" + totalPages + "):");
            if (departments.isEmpty()) {
                System.err.println("Không tìm thấy phòng ban ở trang này.");
            } else {
                departments.forEach(dept -> System.out.println(dept.getDepartmentId() + " | " +
                        dept.getDepartmentName() + " | " +
                        dept.getStatus()));
                System.out.println("Tổng số bản ghi: " + totalDepartments + " | Tổng số trang: " + totalPages);
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

    private static void addDepartment(Scanner scanner, DepartmentService departmentService) {
        Department dept = new Department();
        dept.inputData(scanner);
        int result = departmentService.save(dept);
        if (result == 1) {
            System.out.println("Thêm phòng ban thành công!");
        } else {
            System.err.println(getAddDepartmentErrorMessage(result));
        }
    }

    private static String getAddDepartmentErrorMessage(int p_result) {
        return switch (p_result) {
            case 2 -> "Tên phòng ban đã tồn tại";
            case 3 -> "Tên phòng ban không đúng độ dài (10-100 ký tự)";
            default -> "Lỗi không xác định khi thêm phòng ban";
        };
    }

    private static void updateDepartment(Scanner scanner, DepartmentService departmentService) {
        System.out.println("Nhập mã phòng ban cần cập nhật:");
        String deptIdStr = scanner.nextLine();
        if (!Validator.isValidDataType(deptIdStr, Integer.class)) {
            System.err.println("Mã phòng ban không hợp lệ");
            return;
        }
        int deptId = Integer.parseInt(deptIdStr);
        if (!DepartmentValidator.isValidDepartmentId(deptId)) {
            System.err.println("Mã phòng ban không hợp lệ");
            return;
        }
        Department dept = new Department();
        dept.setDepartmentId(deptId);
        dept.inputData(scanner); // Sử dụng inputData để nhập các trường còn lại
        int result = departmentService.update(dept);
        if (result == 1) {
            System.out.println("Cập nhật phòng ban thành công!");
        } else {
            System.err.println(getUpdateDepartmentErrorMessage(result));
        }
    }

    private static String getUpdateDepartmentErrorMessage(int p_result) {
        return switch (p_result) {
            case 2 -> "Tên phòng ban đã tồn tại";
            case 3 -> "Tên phòng ban không đúng độ dài (10-100 ký tự)";
            default -> "Lỗi không xác định khi cập nhật phòng ban";
        };
    }

    private static void deleteDepartment(Scanner scanner, DepartmentService departmentService) {
        System.out.println("Nhập mã phòng ban cần xóa:");
        String deptIdStr = scanner.nextLine();
        if (!Validator.isValidDataType(deptIdStr, Integer.class)) {
            System.err.println("Mã phòng ban không hợp lệ");
            return;
        }
        int deptId = Integer.parseInt(deptIdStr);
        if (!DepartmentValidator.isValidDepartmentId(deptId)) {
            System.err.println("Mã phòng ban không hợp lệ");
            return;
        }
        Department dept = new Department();
        dept.setDepartmentId(deptId);
        int result = departmentService.delete(dept);
        if (result == 1) {
            System.out.println("Xóa phòng ban thành công!");
        } else {
            System.err.println(getDeleteDepartmentErrorMessage(result));
        }
    }

    private static String getDeleteDepartmentErrorMessage(int p_result) {
        return switch (p_result) {
            case 2 -> "Không thể xóa vì phòng ban còn nhân viên";
            case 3 -> "Phòng ban không tồn tại";
            default -> "Lỗi không xác định khi xóa phòng ban";
        };
    }

    private static void searchDepartmentByName(Scanner scanner, DepartmentService departmentService) {
        System.out.println("Nhập tên phòng ban cần tìm:");
        String name = scanner.nextLine();
        if (name.trim().isEmpty()) {
            System.err.println("Tên không được để trống");
            return;
        }
        List<Department> departments = departmentService.searchByName(name);
        if (departments.isEmpty()) {
            System.err.println("Không tìm thấy phòng ban nào với tên: " + name);
        } else {
            System.out.println("Kết quả tìm kiếm:");
            departments.forEach(dept -> System.out.println(dept.getDepartmentId() + " | " + dept.getDepartmentName() + " | " + dept.getStatus()));
        }
    }
}