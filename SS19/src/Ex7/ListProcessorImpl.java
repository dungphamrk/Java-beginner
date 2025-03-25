package Ex7;

import java.util.List;
import java.util.function.Predicate;

public class ListProcessorImpl implements ListProcessor {
    @Override
    public boolean containsNegative(List<Integer> list) {
        Predicate<Integer> isNegative = number -> number < 0;

        return list.stream().anyMatch(isNegative);
    }

}
