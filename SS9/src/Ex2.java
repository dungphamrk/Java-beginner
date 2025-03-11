public class Ex2 {
    public static class  Employee{
        //Xác định các thuộc tính cơ bản: id, name, department, salary.
        private String name;
        private String id;
        private String department;
        private double salary;
        // Viết constructor có tham số để khởi tạo thông tin nhân viên.
        public  Employee(String name, String id, String department, double salary) {
            this.name = name;
            this.id = id;
            this.department = department;
            this.salary = salary;
        }
        // Viết phương thức hiển thị thông tin nhân viên bao gồm: mã, tên và phòng ban.
        public void displayInfo(){
            System.out.println("Mã "+ id);
            System.out.println("Tên: "+ name);
            System.out.println("Phòng ban: "+ department);
        }
        // Viết getter và setter cho thuộc tính salary để thay đổi lương nếu cần.
        public double getterSalary(){
            return this.salary;
        }
        public  void  setterSalary(double salary){
            this.salary = salary;
        }
        // Viết phương thức để tăng lương nhân viên dựa trên phần trăm(percentage) nhập vào.
        public void increaseSalary(double percentage){
            this.salary+=this.salary*percentage;
            System.out.println("Tăng lương thành công");
        }

    }
    public static void main(String[] args) {
        // Viết đoạn mã trong hàm main để tạo đối tượng nhân viên(Employment) và thực hiện các thao tác: hiển thị thông tin, tăng lương.
        Employee emp= new Employee("DŨng","1","Nhân sự",999999);
        emp.increaseSalary(10);
        emp.displayInfo();
    }
}
