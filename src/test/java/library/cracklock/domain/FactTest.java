package library.cracklock.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import library.cracklock.domain.predicate.CorrectAndWellPlacedFilter;
import library.cracklock.domain.predicate.NotCorrectOrNotWellPlacedFilter;

public class FactTest {

    @Test(expected=IllegalArgumentException.class)
    public void createNotCorrectButWellPlacedFact_ThrowException() throws Exception {
        new Fact(1, 2, false, true);
    }

    @Test
    public void getCorespondingFilterWithCorrectAndWellPlacedFact_GetCorrectAndWellPlacedFilter() throws Exception {
        Fact actual = new Fact(1, 3, true, true);
        assertThat(actual.getCorespondingFilter(3), is(new CorrectAndWellPlacedFilter(actual, 3)));
    }

    @Test
    public void getCorespondingFilterWithCorrectButNotWellPlacedFact_GetNotCorrectOrNotWellPlacedFilter() throws Exception {
        Fact actual = new Fact(1, 3, true, false);
        assertThat(actual.getCorespondingFilter(3), is(new NotCorrectOrNotWellPlacedFilter(actual, 3)));
    }
    
    @Test
    public void getCorespondingFilterWithNeitherCorrectNorWellPlacedFact_GetNotCorrectOrNotWellPlacedFilter() throws Exception {
        Fact actual = new Fact(1, 3, false, false);
        assertThat(actual.getCorespondingFilter(3), is(new NotCorrectOrNotWellPlacedFilter(actual, 3)));
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void test() throws Exception {
        Fact actual = new Fact(1, 5, false, true);
        actual.getCorespondingFilter(3);
    }
}
