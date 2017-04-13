package library.cracklock.application;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import org.junit.Test;

import library.cracklock.domain.Fact;

public class CrackTheLockApplicationTest {

    @Test
    public void testApp() throws Exception {
        assertThat(
            new CrackTheLockApplication(3).solve(
                Arrays.asList(
                    new Fact(682, 1, true, true),
                    new Fact(614, 1, true, false),
                    new Fact(206, 2, true, false),
                    new Fact(738, 0, false, false),
                    new Fact(780, 1, true, false))),
            is(Arrays.asList(42)));
    }

}
