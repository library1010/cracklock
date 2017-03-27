package library.cracklock.domain;

import lombok.Value;

@Value
public class Range {

    private int lowerBound;
    private int upperBound;
    
    public boolean isInRange(int number) {
        return number <= upperBound && number >= lowerBound;
    }
    
    public static Range getRange(int numberLength) {
        if(numberLength < 1) {
            throw new IllegalArgumentException("The number of character is lower than 1");
        }
        
        int lowerBound = 0;
        int upperBound = 0;
        
        for(int i = 0; i < numberLength; i++) {
            lowerBound = lowerBound * 10 + 1;
            upperBound = lowerBound * 9;
            
            if(upperBound < 0) {
                throw new RuntimeException("Integer overflow");
            }
        }
        
        return new Range(lowerBound, upperBound);
    }
}
