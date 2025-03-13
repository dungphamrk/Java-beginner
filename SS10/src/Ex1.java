public class Ex1 {
    // 1. Tính đóng gói là gì? Tại sao tính đóng gói lại quan trọng trong lập trình đối tượng?
    /* Tính đóng gói (Encapsulation) là một trong bốn nguyên tắc cơ bản của lập trình hướng đối tượng (OOP),
            cùng với Kế thừa (Inheritance), Đa hình (Polymorphism) và Trừu tượng (Abstraction). Nó đề cập đến việc "đóng gói" dữ liệu (các biến, thuộc tính) và mã nguồn (các phương thức) thành một đơn
            vị duy nhất (thường là một lớp), đồng thời kiểm soát quyền truy cập vào dữ liệu đó từ bên ngoài.
       Định nghĩa cụ thể: Tính đóng gói là cơ chế ẩn dữ liệu (data hiding) bằng cách giới hạn quyền
            truy cập trực tiếp vào các thuộc tính của một đối tượng. Thay vào đó, việc truy cập hoặc thay đổi dữ liệu chỉ được thực hiện thông qua các phương thức công khai (public methods) như getter và setter.
       1.Bảo vệ dữ liệu: Ngăn chặn việc thay đổi dữ liệu một cách không kiểm soát hoặc không hợp lệ từ bên ngoài lớp.
       2.Tính linh hoạt: Cho phép thay đổi cách triển khai bên trong lớp mà không ảnh hưởng đến mã sử dụng lớp đó.
       3.Dễ bảo trì: Giúp mã nguồn dễ đọc, dễ quản lý và giảm sự phụ thuộc giữa các thành phần trong chương trình.
       4.Tính mô-đun: Tách biệt chức năng của lớp, giúp tái sử dụng và mở rộng mã nguồn hiệu quả hơn.
    */


    // 2. Làm thế nào để áp dụng tính đóng gói trong Java? Giải thích cách sử dụng getter và setter.
    /*
      Sử dụng từ khóa truy cập (access modifiers): Các thuộc tính của lớp thường được khai báo là private để ẩn chúng khỏi truy cập trực tiếp từ bên ngoài. Chỉ các phương thức trong cùng lớp mới có thể truy cập trực tiếp vào các thuộc tính này.
        Getter: Là các phương thức công khai (public) dùng để lấy giá trị của thuộc tính private.
        Setter: Là các phương thức công khai (public) dùng để thiết lập hoặc cập nhật giá trị của thuộc tính private, thường kèm theo logic kiểm tra nếu cần.
     */

    // 3. Ví dụ về cách sử dụng tính đóng gói trong một lớp có thuộc tính name, age
    public static class Person {
        // Thuộc tính private
        private String name;
        private int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            if (name != null && !name.isEmpty()) { // Kiểm tra dữ liệu đầu vào
                this.name = name;
            } else {
                System.out.println("Tên không hợp lệ!");
            }
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            if (age >= 0 && age <= 150) { // Kiểm tra tuổi hợp lệ
                this.age = age;
            } else {
                System.out.println("Tuổi không hợp lệ!");
            }
        }
    }

    public static void main(String[] args) {
        Person person = new Person("Nguyen Van A", 25);
        // Lấy giá trị bằng getter
        System.out.println("Tên: " + person.getName());
        System.out.println("Tuổi: " + person.getAge());
        // Thay đổi giá trị bằng setter
        person.setName("Tran Thi B");
        person.setAge(30);
        System.out.println("Tên mới: " + person.getName());
        System.out.println("Tuổi mới: " + person.getAge());
        // Thử giá trị không hợp lệ
        person.setAge(-5);
    }


    // 4. Lợi ích của việc sử dụng tính đóng gói trong bảo vệ dữ liệu và kiểm soát quyền truy cập
    /*
    Bảo vệ dữ liệu:
        Ngăn chặn truy cập trực tiếp vào các thuộc tính, tránh việc thay đổi dữ liệu một cách không mong muốn hoặc không hợp lệ. Ví dụ: Trong lớp Person, không ai có thể đặt age = -5 trực tiếp mà phải qua setAge, nơi có kiểm tra hợp lệ.
    Kiểm soát quyền truy cập:
        Nhà phát triển có thể quyết định dữ liệu nào chỉ đọc (chỉ cung cấp getter), dữ liệu nào có thể sửa đổi (cung cấp cả getter và setter), hoặc ẩn hoàn toàn (không cung cấp getter/setter).
    Tính linh hoạt trong triển khai:
        Nếu logic bên trong lớp thay đổi (ví dụ: cách lưu trữ age từ int sang String), mã bên ngoài sử dụng getter/setter không cần thay đổi, miễn là giao diện (interface) của phương thức giữ nguyên.
    Tăng tính bảo mật:
        Ẩn chi tiết triển khai bên trong lớp, chỉ lộ ra những gì cần thiết. Điều này đặc biệt hữu ích trong các hệ thống lớn, nơi nhiều lập trình viên làm việc cùng nhau.
    Dễ dàng bảo trì và mở rộng:
        Khi cần thêm logic (ví dụ: kiểm tra đầu vào trong setter), ta chỉ cần sửa trong lớp mà không ảnh hưởng đến các phần khác của chương trình.
    */
}
