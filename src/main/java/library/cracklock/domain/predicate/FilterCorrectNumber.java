package library.cracklock.domain.predicate;

import java.util.function.Predicate;

import library.cracklock.domain.Fact;
import lombok.Getter;

public abstract class FilterCorrectNumber implements Predicate<Integer> {

    @Getter private Fact fact;
    @Getter private int numberLength;
    
    public FilterCorrectNumber(Fact fact, int numberLength) {
        this.fact = fact;
        this.numberLength = numberLength;
    }

}
