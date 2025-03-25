package Ex6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> stringList =new ArrayList<String>( Arrays.asList("java", "lambda", "stream", "functional"));
        StringProcessor processor = (input) -> input.toUpperCase() + " - TECHNICAL";
        List<String> processedList = stringList.stream()
                .map(processor::processString)
                .collect(Collectors.toList());
        processor.printList(processedList);
    }
}
