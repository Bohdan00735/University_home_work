package sixthWork;

import java.util.Comparator;

public class SortByComfortable implements Comparator<Carriage> {
    @Override
    public int compare(Carriage carriage1, Carriage carriage2) {
        return carriage2.comfortable - carriage1.comfortable;
    }
}
