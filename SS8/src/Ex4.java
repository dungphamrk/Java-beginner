public class Ex4 {
    public static void main(String[] args) {
        String initialString = "abcdefghij".repeat(100000);

        System.out.println("Thử nghiệm với StringBuilder...");
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder(initialString);

        sb.reverse();
        System.out.println("Thời gian đảo ngược: " + (System.nanoTime() - start) / 1e6 + " ms");

        start = System.nanoTime();
        sb.insert(500000, "INSERTED");
        System.out.println("Thời gian chèn chuỗi: " + (System.nanoTime() - start) / 1e6 + " ms");

        start = System.nanoTime();
        sb.delete(400000, 400010);
        System.out.println("Thời gian xóa chuỗi: " + (System.nanoTime() - start) / 1e6 + " ms");

        start = System.nanoTime();
        sb.replace(300000, 300010, "REPLACED");
        System.out.println("Thời gian thay thế: " + (System.nanoTime() - start) / 1e6 + " ms");

        System.out.println("Thử nghiệm với StringBuffer...");
        start = System.nanoTime();
        StringBuffer sbf = new StringBuffer(initialString);

        sbf.reverse();
        System.out.println("Thời gian đảo ngược: " + (System.nanoTime() - start) / 1e6 + " ms");

        start = System.nanoTime();
        sbf.insert(500000, "INSERTED");
        System.out.println("Thời gian chèn chuỗi: " + (System.nanoTime() - start) / 1e6 + " ms");

        start = System.nanoTime();
        sbf.delete(400000, 400010);
        System.out.println("Thời gian xóa chuỗi: " + (System.nanoTime() - start) / 1e6 + " ms");

        start = System.nanoTime();
        sbf.replace(300000, 300010, "REPLACED");
        System.out.println("Thời gian thay thế: " + (System.nanoTime() - start) / 1e6 + " ms");
    }
}