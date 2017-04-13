package library.cracklock;

import java.util.Arrays;

import library.cracklock.application.CrackTheLockApplication;
import library.cracklock.domain.Fact;

public class App {
    public static void main(String[] args) {
        System.out.println("The list of possible passcode is:");
        new CrackTheLockApplication(3)
            .solve(
                Arrays.asList(
                    new Fact(682, 1, true, true),
                    new Fact(614, 1, true, false),
                    new Fact(206, 2, true, false),
                    new Fact(738, 0, false, false),
                    new Fact(780, 1, true, false)))
            .stream()
            .forEach(System.out::println);
        System.out.println("Done");
    }
}
