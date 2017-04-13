package library.cracklock.domain.predicate;

import library.cracklock.domain.Fact;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)
public class CorrectAndWellPlacedFilter extends FilterCorrectNumber {

    public CorrectAndWellPlacedFilter(Fact fact, int numberLength) {
        super(fact, numberLength);
    }

    @Override
    public boolean test(Integer t) {
        Fact fact = getFact();
        int samePositionOccurenceTime = 0;
        int testNum = t;
        int factNum = fact.getNumber();
        for (int i = 0; i < getNumberLength(); i++) {
            if (testNum % 10 == factNum % 10) {
                samePositionOccurenceTime++;
            }

            testNum /= 10;
            factNum /= 10;
        }
        return samePositionOccurenceTime == fact.getCorrectDigitQuantity();
    }

}
