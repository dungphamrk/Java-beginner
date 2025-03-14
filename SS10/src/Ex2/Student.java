package Ex2;

import java.util.Scanner;

 /*
    1. Kế thừa là gì? Nó giúp ích gì trong lập trình hướng đối tượng?
    - Kế thừa là một trong những nguyên lý cơ bản của lập trình hướng đối tượng (OOP), cho phép tạo ra các lớp mới từ các lớp đã có, giúp tái sử dụng mã nguồn và tạo ra các quan hệ giữa các đối tượng.
    Trong Java, kế thừa được thực hiện bằng cách sử dụng từ khóa extends. Dưới đây là các loại kế thừa phổ biến và cách sử dụng từ khóa extends
    - 1. Kế thừa giúp giảm trùng lặp mã nguồn → Tiết kiệm thời gian viết code.
      2. Dễ dàng bảo trì và mở rộng → Khi cập nhật lớp cha, lớp con cũng được hưởng lợi.
      3. Hỗ trợ đa hình (polymorphism) → Giúp linh hoạt trong thiết kế phần mềm.
      4. Dễ dàng mở rộng hệ thống → Thêm lớp mới mà không cần thay đổi nhiều code cũ.
    2. Sự khác biệt giữa kế thừa và bao đóng (encapsulation) trong Java là gì?
       - Kế thừa (Inheritance) :
            + Mục đích : Tái sử dụng code, mở rộng tính năng.
            + Cách dùng : Dùng extends để kế thừa lớp cha.
            + Bảo mật : Không giới hạn quyền truy cập dữ liệu.
       - Bao đóng (Encapsulation) :
            + Mục đích : Bảo vệ dữ liệu, kiểm soát quyền truy cập.
            + Cách dùng : Dùng private + getter/setter để truy cập thuộc tính.
            + Bảo mật : Giới hạn truy cập, bảo vệ dữ liệu khỏi thay đổi ngoài ý muốn.
    4. Hãy chỉ ra các lợi ích và hạn chế khi sử dụng kế thừa trong Java?
        - Lợi ích của kế thừa
            1. Tái sử dụng mã nguồn
            2. Dễ dàng mở rộng và bảo trì
            3. Hỗ trợ tính đa hình (Polymorphism)
            4. Tăng khả năng mở rộng hệ thống
        - Hạn chế của kế thừa
            1. Lớp con phụ thuộc vào lớp cha
            2. Không hỗ trợ đa kế thừa trong Java
            3. Dễ gây ràng buộc không cần thiết
            4. Có thể làm tăng độ phức tạp
    * */

public class Student extends Person {
    //Các thuộc tính riêng
    private String studentId;
    private float avgGrade;
    //Các constructor riêng

    public Student() {
    }

    public Student(String name, int age, String address, boolean sex, String studentId, float avgGrade) {
        super(name, age, address, sex);
        this.studentId = studentId;
        this.avgGrade = avgGrade;
    }

    public Student(String name, int age, String address, String studentId) {
        super(name, age, address);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public float getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(float avgGrade) {
        this.avgGrade = avgGrade;
    }

    //Cho phép nhập toàn bộ thông tin của student
    public void inputStudentInfo(Scanner scanner) {
        super.inputData(scanner);
        System.out.println("Nhập mã sinh viên:");
        this.studentId = scanner.nextLine();
        System.out.println("Nhập vào điểm trung bình:");
        this.avgGrade = Float.parseFloat(scanner.nextLine());
    }

    public void displayStudentInfo() {
        super.displayData();
        System.out.printf("Mã SV: %s - Điểm TB: %f\n", this.studentId, this.avgGrade);
    }

    public static int addTwoNumbers(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
}