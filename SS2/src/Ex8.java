import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("-----------Nhập thông tin sinh viên-----------");
        System.out.print("Nhập mã sinh viên: ");
        String studentId = sc.nextLine();

        System.out.print("Nhập tên sinh viên: ");
        String studentName = sc.nextLine();

        System.out.print("Nhập số điện thoại sinh viên: ");
        String phoneNumber = sc.nextLine();

        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        String birthDate = sc.nextLine();

        System.out.print("Nhập giới tính sinh viên (1: Nam, 0: Nữ): ");
        int gender = sc.nextInt();
        sc.nextLine();

        System.out.println("\n-----------Nhập điểm sinh viên-----------");
        System.out.print("Nhập điểm toán: ");
        double math = sc.nextDouble();

        System.out.print("Nhập điểm lý: ");
        double physics = sc.nextDouble();

        System.out.print("Nhập điểm hóa: ");
        double chemistry = sc.nextDouble();

        System.out.print("Nhập điểm sinh học: ");
        double biology = sc.nextDouble();

        System.out.print("Nhập điểm ngoại ngữ: ");
        double english = sc.nextDouble();

        double averageScore = (math + physics + chemistry + biology + english) / 5;


        System.out.println("\n-----------Hiển thị thông tin sinh viên-----------");
        System.out.println("Mã sinh viên: " + studentId + " | Tên sinh viên: " + studentName +
                " | Giới tính: " + (gender == 1 ? "Nam" : "Nữ"));
        System.out.println("Ngày sinh: " + birthDate + " | Số điện thoại: " + phoneNumber);
        System.out.println("Điểm Toán: " + math + " | Điểm Vật lý: " + physics +
                " | Điểm Hóa học: " + chemistry + " | Điểm Sinh học: " + biology +
                " | Điểm Ngoại ngữ: " + english);
        System.out.println("Điểm trung bình: " + String.format("%.2f", averageScore));

        sc.close();
    }
}
