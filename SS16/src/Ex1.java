import java.util.ArrayList;
import java.util.Iterator;

public class Ex1 {
    public static void main(String[] args) {
        ArrayList<String> listStudents = new ArrayList<>();
        listStudents.add("Nguyễn Văn A");
        listStudents.add("Nguyễn Văn B");
        listStudents.add("Nguyễn Văn C");
        listStudents.add("Nguyễn Văn D");
        listStudents.add("Nguyễn Văn E");
        for (int i = 0; i < listStudents.size(); i++) {
            System.out.println(listStudents.get(i));
        }
        for(String s: listStudents){
            System.out.println(s);
        }
        Iterator<String> iteStudents = listStudents.iterator();
        System.out.println(3);
        while (iteStudents.hasNext()) {
            System.out.println( iteStudents.next());
        }
    }
}
