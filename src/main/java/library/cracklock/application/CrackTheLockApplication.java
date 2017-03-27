package library.cracklock.application;

import java.util.List;

import library.cracklock.domain.Fact;
import library.cracklock.repository.CrackLockRepository;

public class CrackTheLockApplication {

    private CrackLockRepository repository;
    private int numberLength;

    public CrackTheLockApplication(int numberLength) {
        this.numberLength = numberLength;
        repository = new CrackLockRepository(numberLength);
    }

    public void solve(List<Fact> factList) {
        factList.stream().forEach(e -> repository.reduce(e.getCorespondingFilter(numberLength)));

        System.out.println("The list of possible passcode is:");
        repository.getTheCurrentNumberList().stream().forEach(System.out::println);
        System.out.println("Done");
    }
}
