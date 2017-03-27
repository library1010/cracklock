package library.cracklock.repository;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import library.cracklock.domain.Range;

public class CrackLockRepository {

    private List<Integer> numbersList;

    public CrackLockRepository(int numberLength) {
        numbersList = new ArrayList<>();
        Range range = Range.getRange(numberLength);
        IntStream.rangeClosed(0, range.getUpperBound()).forEach(numbersList::add);
    }

    public List<Integer> getTheCurrentNumberList() {
        return new ArrayList<>(numbersList);
    }

    public List<Integer> reduce(Predicate<Integer> predicate) {
        numbersList = numbersList.parallelStream().filter(predicate).collect(toList());
        return getTheCurrentNumberList();
    }
}
