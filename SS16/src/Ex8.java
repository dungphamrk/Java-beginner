import java.util.ArrayList;

public class Ex8 {
    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("banana");
        stringList.add("apple");
        stringList.add("cherry");
        stringList.add("blueberry");
        stringList.add("pear");
        stringList.add("grape");
        stringList.add("kiwi");
        System.out.println("Danh sách trước khi sắp xếp:");
        for (String s : stringList) {
            System.out.println(s);
        }
        int n = stringList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                String s1 = stringList.get(j);
                String s2 = stringList.get(j + 1);
                if (s1.length() > s2.length() ||
                        (s1.length() == s2.length() && s1.compareTo(s2) > 0)) {
                    stringList.set(j, s2);
                    stringList.set(j + 1, s1);
                }
            }
        }
        System.out.println("\nDanh sách sau khi sắp xếp:");
        for (String s : stringList) {
            System.out.println(s);
        }
    }
}
