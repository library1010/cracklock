package library.cracklock.domain.predicate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import library.cracklock.domain.Fact;
import library.cracklock.domain.predicate.CorrectAndWellPlacedFilter;

public class CorrectAndWellPlacedFilterTest {
    
    @Test
    public void testFact() throws Exception {
        assertThat(new CorrectAndWellPlacedFilter(new Fact(682, 1, true, true), 3).test(602), is(false));
        assertThat(new CorrectAndWellPlacedFilter(new Fact(682, 1, true, true), 3).test(601), is(true));
        assertThat(new CorrectAndWellPlacedFilter(new Fact(682, 1, true, true), 3).test(81), is(true));
        assertThat(new CorrectAndWellPlacedFilter(new Fact(682, 1, true, true), 3).test(2), is(true));
        assertThat(new CorrectAndWellPlacedFilter(new Fact(682, 1, true, true), 3).test(666), is(true));
        assertThat(new CorrectAndWellPlacedFilter(new Fact(682, 1, true, true), 3).test(268), is(false));
        assertThat(new CorrectAndWellPlacedFilter(new Fact(682, 3, true, true), 3).test(682), is(true));
        assertThat(new CorrectAndWellPlacedFilter(new Fact(682, 2, true, true), 3).test(602), is(true));
        assertThat(new CorrectAndWellPlacedFilter(new Fact(682, 1, true, true), 3).test(42), is(true));
    }
}
