package library.cracklock.domain;

import java.util.function.Predicate;

import library.cracklock.domain.predicate.CorrectAndWellPlacedFilter;
import library.cracklock.domain.predicate.NotCorrectOrNotWellPlacedFilter;
import lombok.Getter;

public class Fact {

    @Getter private int number;
    private Correctness correctness;

    public Fact(int number, int numberOfCharacter, boolean isCorrect, boolean isWellPlaced) {
        if (!isCorrect && isWellPlaced) {
            throw new IllegalArgumentException("Boohoo, there is no fact that incorrect and well place.");
        }

        this.number = number;
        this.correctness = new Correctness(numberOfCharacter, isCorrect, isWellPlaced);
    }

    public int getNumberOfCorrectCharacter() {
        return correctness.getNumberOfCharacter();
    }

    public Predicate<Integer> getCorespondingFilter(int numberLength) {
        return isCorrectAndWellPlaced()
            ? new CorrectAndWellPlacedFilter(this, numberLength)
            : new NotCorrectOrNotWellPlacedFilter(this, numberLength);
    }

    private boolean isCorrectAndWellPlaced() {
        return correctness.isCorrect() && correctness.isWellPlaced();
    }
}
