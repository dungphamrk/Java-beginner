package business.model;

import validate.EmployeeValidator;
import validate.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Employee implements Inputable {
    private String employeeId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private Gender gender;
    private int payGrade;
    private double salary;
    private LocalDate birthDate;
    private String address;
    private Status status;
    private int departmentId;

    public enum Gender {MALE, FEMALE, OTHER}
    public enum Status {ACTIVE, INACTIVE, ONLEAVE, POLICYLEAVE}

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập mã nhân viên (E + 4 số):");
        while (true) {
            String employeeId = scanner.nextLine();
            if (EmployeeValidator.isValidEmployeeId(employeeId)) {
                this.employeeId = employeeId;
                break;
            }
            System.err.println("Mã nhân viên không đúng định dạng (E + 4 số), vui lòng nhập lại:");
        }

        System.out.println("Nhập tên nhân viên (15-150 ký tự):");
        while (true) {
            String fullName = scanner.nextLine();
            if (EmployeeValidator.isValidFullName(fullName)) {
                this.fullName = fullName;
                break;
            }
            System.err.println("Tên nhân viên phải từ 15 đến 150 ký tự, vui lòng nhập lại:");
        }

        System.out.println("Nhập email:");
        while (true) {
            String email = scanner.nextLine();
            if (Validator.isValidEmail(email)) {
                this.email = email;
                break;
            }
            System.err.println("Email không đúng định dạng, vui lòng nhập lại:");
        }

        System.out.println("Nhập số điện thoại (10 số, đầu số hợp lệ):");
        while (true) {
            String phoneNumber = scanner.nextLine();
            if (Validator.isValidPhoneNumberVN(phoneNumber)) {
                this.phoneNumber = phoneNumber;
                break;
            }
            System.err.println("Số điện thoại không hợp lệ, vui lòng nhập lại:");
        }

        System.out.println("Nhập giới tính (MALE/FEMALE/OTHER):");
        while (true) {
            String genderStr = scanner.nextLine();
            if (Validator.isValidDataType(genderStr, Gender.class)) {
                this.gender = Gender.valueOf(genderStr.toUpperCase());
                break;
            }
            System.err.println("Giới tính không hợp lệ (MALE, FEMALE, OTHER), vui lòng nhập lại:");
        }

        System.out.println("Nhập bậc lương (> 0):");
        while (true) {
            String payGradeStr = scanner.nextLine();
            if (Validator.isValidDataType(payGradeStr, Integer.class)) {
                int payGrade = Integer.parseInt(payGradeStr);
                if (EmployeeValidator.isValidPayGrade(payGrade)) {
                    this.payGrade = payGrade;
                    break;
                }
            }
            System.err.println("Bậc lương phải lớn hơn 0, vui lòng nhập lại:");
        }

        System.out.println("Nhập lương (> 0):");
        while (true) {
            String salaryStr = scanner.nextLine();
            if (Validator.isValidDataType(salaryStr, Double.class)) {
                double salary = Double.parseDouble(salaryStr);
                if (EmployeeValidator.isValidSalary(salary)) {
                    this.salary = salary;
                    break;
                }
            }
            System.err.println("Lương phải lớn hơn 0, vui lòng nhập lại:");
        }

        System.out.println("Nhập ngày sinh (dd/MM/yyyy):");
        while (true) {
            String birthDateStr = scanner.nextLine();
            if (Validator.isValidDataType(birthDateStr, LocalDate.class)) {
                LocalDate birthDate = LocalDate.parse(birthDateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                if (EmployeeValidator.isValidBirthDate(birthDate)) {
                    this.birthDate = birthDate;
                    break;
                }
            }
            System.err.println("Ngày sinh không hợp lệ hoặc không trước ngày hiện tại, vui lòng nhập lại:");
        }

        System.out.println("Nhập địa chỉ:");
        while (true) {
            String address = scanner.nextLine();
            if (EmployeeValidator.isValidAddress(address)) {
                this.address = address;
                break;
            }
            System.err.println("Địa chỉ không được để trống và tối đa 255 ký tự, vui lòng nhập lại:");
        }

        System.out.println("Nhập trạng thái (ACTIVE/INACTIVE/ONLEAVE/POLICYLEAVE):");
        while (true) {
            String statusStr = scanner.nextLine();
            if (Validator.isValidDataType(statusStr, Status.class)) {
                this.status = Status.valueOf(statusStr.toUpperCase());
                break;
            }
            System.err.println("Trạng thái không hợp lệ (ACTIVE, INACTIVE, ONLEAVE, POLICYLEAVE), vui lòng nhập lại:");
        }

        System.out.println("Nhập mã phòng ban:");
        while (true) {
            String deptIdStr = scanner.nextLine();
            if (Validator.isValidDataType(deptIdStr, Integer.class)) {
                int deptId = Integer.parseInt(deptIdStr);
                if (EmployeeValidator.isValidDepartmentId(deptId)) {
                    this.departmentId = deptId;
                    break;
                }
            }
            System.err.println("Mã phòng ban không hợp lệ, vui lòng nhập lại:");
        }
    }

    // Getters and setters
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getPayGrade() {
        return payGrade;
    }

    public void setPayGrade(int payGrade) {
        this.payGrade = payGrade;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}