public class Ex4 {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        boolean c = true;
        if (a && b) {
            System.out.println("Cả hai đều đúng");
        }
        if (a || b) {
            System.out.println("Ít nhất một đúng");
        }
        if (!a && b) {
            System.out.println("Không đúng");
        }
        System.out.println("Giá trị ban đầu của c: " + c);
        c = !c;
        System.out.println("Giá trị đảo ngược của c: " + c);
        if ((a && !b) || (b && !a)) {
            System.out.println("1 đúng , 1 sai");
        }
    }
}
