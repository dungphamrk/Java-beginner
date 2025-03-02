import java.util.Scanner;

public class Ex9_new {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập 3 cạnh của tam giác: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        double perimeter = a + b + c;
        double semiPerimeter = perimeter / 2;
        double area = Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));

        System.out.println("Chu vi : " + perimeter);
        System.out.println("Diện tích : " + area);
    }
}
