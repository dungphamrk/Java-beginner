package validate;

import business.model.Employee;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class EmployeeValidator {

    public static boolean isValidEmployeeId(String employeeId) {
        String regex = "^E[0-9]{4}$";
        return employeeId != null && Pattern.matches(regex, employeeId.trim());
    }

    public static boolean isValidFullName(String fullName) {
        return fullName != null && fullName.trim().length() >= 15 && fullName.trim().length() <= 150;
    }

    public static boolean isValidPayGrade(int payGrade) {
        return payGrade > 0;
    }

    public static boolean isValidSalary(double salary) {
        return salary > 0;
    }

    public static boolean isValidBirthDate(LocalDate birthDate) {
        return birthDate != null && birthDate.isBefore(LocalDate.now());
    }

    public static boolean isValidAddress(String address) {
        return address != null && !address.trim().isEmpty() && address.trim().length() <= 255;
    }

    public static boolean isValidDepartmentId(int departmentId) {
        return departmentId > 0;
    }

    public static String validateEmployee(Employee employee) {
        if (!isValidEmployeeId(employee.getEmployeeId())) {
            return "Mã nhân viên không đúng định dạng (E + 4 số)";
        }
        if (!isValidFullName(employee.getFullName())) {
            return "Tên nhân viên phải từ 15 đến 150 ký tự";
        }
        if (!Validator.isValidEmail(employee.getEmail())) {
            return "Email không đúng định dạng";
        }
        if (!Validator.isValidPhoneNumberVN(employee.getPhoneNumber())) {
            return "Số điện thoại không hợp lệ";
        }
        if (employee.getGender() == null || !Validator.isValidDataType(employee.getGender().name(), Employee.Gender.class)) {
            return "Giới tính không hợp lệ (MALE, FEMALE, OTHER)";
        }
        if (!isValidPayGrade(employee.getPayGrade())) {
            return "Bậc lương phải lớn hơn 0";
        }
        if (!isValidSalary(employee.getSalary())) {
            return "Lương phải lớn hơn 0";
        }
        if (!isValidBirthDate(employee.getBirthDate())) {
            return "Ngày sinh không hợp lệ hoặc không trước ngày hiện tại";
        }
        if (!isValidAddress(employee.getAddress())) {
            return "Địa chỉ không được để trống và tối đa 255 ký tự";
        }
        if (employee.getStatus() == null || !Validator.isValidDataType(employee.getStatus().name(), Employee.Status.class)) {
            return "Trạng thái không hợp lệ (ACTIVE, INACTIVE, ONLEAVE, POLICYLEAVE)";
        }
        if (!isValidDepartmentId(employee.getDepartmentId())) {
            return "Mã phòng ban không hợp lệ";
        }
        return null; // Hợp lệ
    }
}