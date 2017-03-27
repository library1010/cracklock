package library.cracklock.domain.predicate;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import library.cracklock.domain.Fact;

public class NotCorrectOrNotWellPlacedFilter extends FilterCorrectNumber {

    public NotCorrectOrNotWellPlacedFilter(Fact fact, int numberLength) {
        super(fact, numberLength);
    }

    @Override
    public boolean test(Integer t) {
        Fact fact = getFact();

        if (fact.getCorrectDigitQuantity() != 0 && hasCorrectNumberInCorrectPosition(t, fact)) {
            return false;
        }

        Set<Character> set = new HashSet<>();
        String testNum = formatInteger(getNumberLength(), t);
        String factNum = formatInteger(getNumberLength(), fact.getNumber());
        IntStream.concat(testNum.chars(), factNum.chars()).forEach(value -> set.add((char) value));
        return testNum.length() * 2 == set.size() + fact.getCorrectDigitQuantity();
    }

    private String formatInteger(int numberLength, int number) {
        return String.format("%0" + numberLength + "d", number);
    }

    private boolean hasCorrectNumberInCorrectPosition(Integer t, Fact fact) {
        for (int i = 1; i <= fact.getCorrectDigitQuantity(); i++) {
            if (new Fact(fact.getNumber(), i, true, true).getCorespondingFilter(getNumberLength()).test(t)) {
                return true;
            }
        }
        return false;
    }

}
