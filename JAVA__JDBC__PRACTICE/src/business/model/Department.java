package business.model;

import validate.DepartmentValidator;
import validate.Validator;

import java.util.Scanner;

public class Department implements Inputable {
    private int departmentId;
    private String departmentName;
    private String description;
    private Status status;

    public enum Status {ACTIVE, INACTIVE}

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập tên phòng ban (10-100 ký tự):");
        while (true) {
            String departmentName = scanner.nextLine();
            if (DepartmentValidator.isValidDepartmentName(departmentName)) {
                this.departmentName = departmentName;
                break;
            }
            System.err.println("Tên phòng ban phải từ 10 đến 100 ký tự, vui lòng nhập lại:");
        }

        System.out.println("Nhập mô tả (tối đa 255 ký tự, có thể rỗng):");
        while (true) {
            String description = scanner.nextLine();
            if (DepartmentValidator.isValidDescription(description)) {
                this.description = description;
                break;
            }
            System.err.println("Mô tả tối đa 255 ký tự, vui lòng nhập lại:");
        }

        System.out.println("Nhập trạng thái (ACTIVE/INACTIVE):");
        while (true) {
            String statusStr = scanner.nextLine();
            if (Validator.isValidDataType(statusStr, Status.class)) {
                this.status = Status.valueOf(statusStr.toUpperCase());
                break;
            }
            System.err.println("Trạng thái không hợp lệ (ACTIVE, INACTIVE), vui lòng nhập lại:");
        }
    }

    // Getters and setters
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}