package library.cracklock.domain.predicate;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import library.cracklock.domain.Fact;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)
public class NotCorrectOrNotWellPlacedFilter extends FilterCorrectNumber {

    public NotCorrectOrNotWellPlacedFilter(Fact fact, int numberLength) {
        super(fact, numberLength);
    }

    @Override
    public boolean test(Integer t) {
        Fact fact = getFact();

        // This is not a perfect solution, but it worked (because of my own heurestic implementation)
        // Feel free to improve this solution
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
        return IntStream
            .rangeClosed(1, fact.getCorrectDigitQuantity())
            .filter(i -> new Fact(fact.getNumber(), i, true, true).getCorespondingFilter(getNumberLength()).test(t))
            .count() > 0;
    }

}
