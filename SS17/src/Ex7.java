import java.util.*;

public class Ex7 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String s=sc.nextLine();
        String[] words = s.toLowerCase().split("\\W+");
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        Set<String> uniqueWords = new HashSet<>(wordList);
        Collections.sort(wordList);
        for (String word : uniqueWords) {
            int count = 0;
            for (String w : wordList) {
                if (w.equals(word)) {
                    count++;
                }
            }
            System.out.println(word + ": " + count);
        }
    }
}
