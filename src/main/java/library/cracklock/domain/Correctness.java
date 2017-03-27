package library.cracklock.domain;

import lombok.Value;

@Value
class Correctness {

    private int digitQuantity;
    private boolean isCorrect;
    private boolean isWellPlaced;
    
}
