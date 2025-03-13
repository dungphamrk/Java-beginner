public class Ex9 {
    public static class Fraction{
        public int numerator;
        public int denominator;
        public Fraction(int numerator, int denominator){
            if (denominator == 0) {
                System.out.println("Mẫu số ko thể bằng 0");
                System.exit(0);
            }
            this.numerator = numerator;
            this.denominator = denominator;
            simplify();
        }
        public Fraction add(Fraction other) {
            return new Fraction(this.numerator * other.denominator + other.numerator * this.denominator, this.denominator * other.denominator);
        }
        public Fraction subtract(Fraction other) {
            return new Fraction( this.numerator * other.denominator - other.numerator * this.denominator, this.denominator * other.denominator);
        }
        public Fraction multiply(Fraction other) {
            return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);
        }
        public Fraction divide(Fraction other) {
            return new Fraction(this.numerator * other.denominator, this.denominator * other.numerator);
        }
        // tìm ước chung lớn nhất
        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        private void simplify() {
            int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
            numerator /= gcd;
            denominator /= gcd;
            // Đảm bảo mẫu số luôn dương
            if (denominator < 0) {
                numerator = -numerator;
                denominator = -denominator;
            }
        }
        public String toString() {
            return numerator + "/" + denominator;
        }
    }
    public static void main(String[] args) {
        Fraction f1 = new Fraction(3, 6);
        Fraction f2 = new Fraction(2, 5);
        System.out.println("Phân số 1: " + f1);
        System.out.println("Phân số 2: " + f2);
        System.out.println("Cộng: " + f1.add(f2));
        System.out.println("Trừ: " + f1.subtract(f2));
        System.out.println("Nhân: " + f1.multiply(f2));
        System.out.println("Chia: " + f1.divide(f2));
    }
}
