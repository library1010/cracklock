package library.cracklock.domain.predicate;

import java.util.function.Predicate;

import library.cracklock.domain.Fact;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public abstract class FilterCorrectNumber implements Predicate<Integer> {

    private Fact fact;
    private int numberLength;

}
