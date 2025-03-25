package Ex8;

import java.util.List;

public class ListProcessorImpl implements   ListProcessor{

    @Override
    public int sumOddNumbers(List<Integer> list) {
        return list.stream().filter(i -> i%2!=0).reduce(0, Integer::sum);
    }

}
