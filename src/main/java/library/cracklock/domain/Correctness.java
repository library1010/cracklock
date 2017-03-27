package library.cracklock.domain;

import lombok.Value;

@Value
public class Correctness {

    private int numberOfCharacter;
    private boolean isCorrect;
    private boolean isWellPlaced;
    
}
