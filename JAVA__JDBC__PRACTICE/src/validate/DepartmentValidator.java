package validate;

import business.model.Department;

public class DepartmentValidator {

    public static boolean isValidDepartmentName(String departmentName) {
        return departmentName != null && departmentName.trim().length() >= 10 && departmentName.trim().length() <= 100;
    }

    public static boolean isValidDescription(String description) {
        return description == null || description.trim().length() <= 255;
    }

    public static boolean isValidDepartmentId(int departmentId) {
        return departmentId > 0;
    }

    public static String validateDepartment(Department department) {
        if (!isValidDepartmentName(department.getDepartmentName())) {
            return "Tên phòng ban phải từ 10 đến 100 ký tự";
        }
        if (!isValidDescription(department.getDescription())) {
            return "Mô tả tối đa 255 ký tự";
        }
        if (department.getStatus() == null || !Validator.isValidDataType(department.getStatus().name(), Department.Status.class)) {
            return "Trạng thái không hợp lệ (ACTIVE, INACTIVE)";
        }
        if (department.getDepartmentId() != 0 && !isValidDepartmentId(department.getDepartmentId())) {
            return "Mã phòng ban không hợp lệ";
        }
        return null; // Hợp lệ
    }
}