package library.cracklock.domain.predicate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import library.cracklock.domain.Fact;
import library.cracklock.domain.predicate.NotCorrectOrNotWellPlacedFilter;

public class NotCorrectOrNotWellPlacedFilterTest {

    @Test
    public void testFact() throws Exception {
        assertThat(new NotCorrectOrNotWellPlacedFilter(new Fact(614, 0, false, false), 3).test(602), is(false));
        assertThat(new NotCorrectOrNotWellPlacedFilter(new Fact(614, 0, false, false), 3).test(600), is(false));
        assertThat(new NotCorrectOrNotWellPlacedFilter(new Fact(614, 0, false, false), 3).test(1), is(false));
        assertThat(new NotCorrectOrNotWellPlacedFilter(new Fact(614, 0, false, false), 3).test(459), is(false));
        assertThat(new NotCorrectOrNotWellPlacedFilter(new Fact(614, 0, false, false), 3).test(235), is(true));
        assertThat(new NotCorrectOrNotWellPlacedFilter(new Fact(614, 1, true, false), 3).test(42), is(true));
        assertThat(new NotCorrectOrNotWellPlacedFilter(new Fact(614, 1, true, false), 3).test(602), is(false));
        assertThat(new NotCorrectOrNotWellPlacedFilter(new Fact(206, 2, true, false), 3).test(42), is(true));
        assertThat(new NotCorrectOrNotWellPlacedFilter(new Fact(738, 0, false, false), 3).test(42), is(true));
        assertThat(new NotCorrectOrNotWellPlacedFilter(new Fact(780, 1, true, false), 3).test(42), is(true));
        assertThat(new NotCorrectOrNotWellPlacedFilter(new Fact(206, 2, true, false), 3).test(102), is(false));
        assertThat(new NotCorrectOrNotWellPlacedFilter(new Fact(206, 2, true, false), 3).test(402), is(false));
        assertThat(new NotCorrectOrNotWellPlacedFilter(new Fact(206, 2, true, false), 3).test(605), is(false));
    }
}
