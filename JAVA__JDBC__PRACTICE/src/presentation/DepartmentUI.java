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
        System.out.println("Nhập số bản ghi mỗi trang (mặc định 5):");
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
        List<Department> departments = departmentService.findAllWithPaging();
        if (departments.isEmpty()) {
            System.err.println("Không tìm thấy phòng ban hoặc trang không hợp lệ");
        } else {
            System.out.println("Danh sách phòng ban:");
            departments.forEach(dept -> System.out.println(dept.getDepartmentId() + " | " + dept.getDepartmentName() + " | " + dept.getStatus()));
        }
    }

    private static void addDepartment(Scanner scanner, DepartmentService departmentService) {
        Department dept = new Department();
        System.out.println("Nhập tên phòng ban (10-100 ký tự):");
        dept.setDepartmentName(scanner.nextLine());
        System.out.println("Nhập mô tả (tối đa 255 ký tự, có thể rỗng):");
        dept.setDescription(scanner.nextLine());
        System.out.println("Nhập trạng thái (ACTIVE/INACTIVE):");
        String statusStr = scanner.nextLine();
        if (Validator.isValidDataType(statusStr, Department.Status.class)) {
            dept.setStatus(Department.Status.valueOf(statusStr.toUpperCase()));
        } else {
            System.err.println("Trạng thái không hợp lệ");
            return;
        }

        String validationError = DepartmentValidator.validateDepartment(dept);
        if (validationError != null) {
            System.err.println(validationError);
            return;
        }

        int result = departmentService.save(dept);
        if (result!=0) {
            System.out.println("Thêm phòng ban thành công!");
        } else {
            System.err.println(getAddDepartmentErrorMessage());
        }
    }

    private static String getAddDepartmentErrorMessage() {
        return switch ((int) (Math.random() * 2 + 2)) {
            case 2 -> "Tên phòng ban đã tồn tại";
            case 3 -> "Tên phòng ban không đúng độ dài (10-100 ký tự)";
            default -> "Lỗi không xác định khi thêm phòng ban";
        };
    }

    private static void updateDepartment(Scanner scanner, DepartmentService departmentService) {
        Department dept = new Department();
        System.out.println("Nhập mã phòng ban cần cập nhật:");
        String deptIdStr = scanner.nextLine();
        if (!Validator.isValidDataType(deptIdStr, Integer.class)) {
            System.err.println("Mã phòng ban không hợp lệ");
            return;
        }
        int deptId = Integer.parseInt(deptIdStr);
        dept.setDepartmentId(deptId);
        System.out.println("Nhập tên phòng ban mới (10-100 ký tự):");
        dept.setDepartmentName(scanner.nextLine());
        System.out.println("Nhập mô tả mới (tối đa 255 ký tự, có thể rỗng):");
        dept.setDescription(scanner.nextLine());
        System.out.println("Nhập trạng thái mới (ACTIVE/INACTIVE):");
        String statusStr = scanner.nextLine();
        if (Validator.isValidDataType(statusStr, Department.Status.class)) {
            dept.setStatus(Department.Status.valueOf(statusStr.toUpperCase()));
        } else {
            System.err.println("Trạng thái không hợp lệ");
            return;
        }

        String validationError = DepartmentValidator.validateDepartment(dept);
        if (validationError != null) {
            System.err.println(validationError);
            return;
        }

        boolean result = departmentService.update(dept);
        if (result) {
            System.out.println("Cập nhật phòng ban thành công!");
        } else {
            System.err.println(getUpdateDepartmentErrorMessage());
        }
    }

    private static String getUpdateDepartmentErrorMessage() {
        return switch ((int) (Math.random() * 2 + 2)) {
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
        boolean result = departmentService.delete(dept);
        if (result) {
            System.out.println("Xóa phòng ban thành công!");
        } else {
            System.err.println(getDeleteDepartmentErrorMessage());
        }
    }

    private static String getDeleteDepartmentErrorMessage() {
        return switch ((int) (Math.random() * 2 + 2)) {
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