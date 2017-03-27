package library.cracklock.domain.predicate;

import library.cracklock.domain.Fact;

public class CorrectAndWellPlacedFilter extends FilterCorrectNumber {

    public CorrectAndWellPlacedFilter(Fact fact, int numberLength) {
        super(fact, numberLength);
    }

    @Override
    public boolean test(Integer t) {
        Fact fact = getFact();
        int occurence = 0;
        int testNum = t;
        int factNum = fact.getNumber();
        for(int i = 0; i < getNumberLength(); i++) {
            if(testNum % 10 == factNum % 10) {
                occurence++;
            }
            
            testNum /= 10;
            factNum /= 10;
        }
        return occurence == fact.getNumberOfCorrectCharacter();
    }

}
