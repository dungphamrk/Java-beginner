import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập hệ số từ người dùng
        System.out.print("Nhập hệ số a: ");
        double a = sc.nextDouble();
        System.out.print("Nhập hệ số b: ");
        double b = sc.nextDouble();
        System.out.print("Nhập hệ số c: ");
        double c = sc.nextDouble();
        System.out.print("Nhập hệ số d: ");
        double d = sc.nextDouble();

        if (a == 0) {
            // Trường hợp phương trình bậc hai
            if (b == 0) {
                if (c == 0) {
                    System.out.println(d == 0 ? "Phương trình có vô số nghiệm." : "Phương trình vô nghiệm.");
                } else {
                    System.out.println("Phương trình có một nghiệm: x = " + (-d / c));
                }
            } else {
                double delta = c * c - 4 * b * d;
                if (delta > 0) {
                    double x1 = (-c + Math.sqrt(delta)) / (2 * b);
                    double x2 = (-c - Math.sqrt(delta)) / (2 * b);
                    System.out.println("Phương trình có hai nghiệm phân biệt: x1 = " + x1 + ", x2 = " + x2);
                } else if (delta == 0) {
                    System.out.println("Phương trình có nghiệm kép: x = " + (-c / (2 * b)));
                } else {
                    System.out.println("Phương trình vô nghiệm.");
                }
            }
        } else {
            // Trường hợp phương trình bậc ba
            cubicSolver(a, b, c, d);
        }
    }

    public static void cubicSolver(double a, double b, double c, double d) {
        double delta0 = b * b - 3 * a * c;
        double delta1 = 2 * b * b * b - 9 * a * b * c + 27 * a * a * d;

        double discriminant = delta1 * delta1 - 4 * delta0 * delta0 * delta0;

        if (discriminant > 0) {
            double C = Math.cbrt((delta1 + Math.sqrt(discriminant)) / 2);
            for (int k = 0; k < 3; k++) {
                double realPart = -1 / (3 * a) * (b + Math.pow(-1, k / 3.0) * C + delta0 / (Math.pow(-1, k / 3.0) * C));
                System.out.println("Nghiệm thực x" + (k + 1) + " = " + realPart);
            }
        } else if (discriminant == 0) {
            double x1 = -1 / (3 * a) * (b + Math.cbrt(delta1 / 2));
            double x2 = -1 / (3 * a) * (b - Math.cbrt(delta1 / 2));
            System.out.println("Phương trình có nghiệm kép x1 = x2 = " + x1);
            System.out.println("Phương trình có một nghiệm đơn x3 = " + x2);
        } else {
            double theta = Math.acos(delta1 / (2 * Math.sqrt(delta0 * delta0 * delta0)));
            for (int k = 0; k < 3; k++) {
                double x = -1 / (3 * a) * (b + 2 * Math.sqrt(delta0) * Math.cos((theta - 2 * Math.PI * k) / 3));
                System.out.println("Nghiệm thực x" + (k + 1) + " = " + x);
            }
        }
    }
}
