public class Ex6 {
    public static void main(String[] args) {
        String str1 = "Hello";
        long startTime = 0, endTime=0;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            str1 += "word";
        }
        endTime = System.currentTimeMillis();
        System.out.println("String: " + (endTime - startTime) + " ms");

        StringBuilder str2 = new StringBuilder();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            str2.append("word");
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder: " + (endTime - startTime) + " ms");

        StringBuffer str3 = new StringBuffer();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            str3.append("word");
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer: " + (endTime - startTime) + " ms");
    }
}