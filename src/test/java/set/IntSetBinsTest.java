package set;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class IntSetBinsTest {
    @Test(expected = IllegalArgumentException.class)
    public void testCreateWithNegativeSize() {
        IntSetBins bins = new IntSetBins(-1, 0);
    }

    @Test
    public void testSetMaxElement() {
        IntSetBins bins = new IntSetBins(10, 100);
        assertThat(bins.getMaxElement(), is(equalTo(10)));
    }

    @Test
    public void testSetMaxValue() {
        IntSetBins bins = new IntSetBins(10, -1);
        assertThat(bins.getMaxValue(), is(equalTo(-1)));
    }

    @Test
    public void testNewbinsSize() {
        IntSetBins bins = new IntSetBins(100, 100);
        assertThat(bins.size(), is(equalTo(0)));
    }

    @Test
    public void testInsert() {
        IntSetBins bins = new IntSetBins(100, 100);
        bins.insert(10);

        assertThat(bins.size(), is(equalTo(1)));
    }

    @Test
    public void testMultipleInsert() {
        IntSetBins bins = new IntSetBins(100, 100);

        for (int i = 0; i < 10; ++i) {
            bins.insert(i);
        }

        assertThat(bins.size(), is(equalTo(10)));
    }

    @Test
    public void testDuplicateInsert() {
        IntSetBins bins = new IntSetBins(100, 100);
        bins.insert(10);
        bins.insert(10);

        assertThat(bins.size(), is(equalTo(1)));
    }

    @Test
    public void testDuplicateMultipleInsert() {
        IntSetBins bins = new IntSetBins(100, 100);

        for (int i = 0; i < 10; ++i) {
            bins.insert(i);
            bins.insert(i);
        }

        assertThat(bins.size(), is(equalTo(10)));
    }

    @Test
    public void testOverMaxElementInsert() {
        IntSetBins bins = new IntSetBins(10, 100);

        for (int i = 0; i < 1000; ++i) {
            bins.insert(i);
        }

        assertThat(bins.size(), is(equalTo(10)));
    }

    @Test
    public void testOverMaxValueInsert() {
        IntSetBins bins = new IntSetBins(10, -1);

        for (int i = 0; i < 1000; ++i) {
            bins.insert(i);
        }

        assertThat(bins.size(), is(equalTo(0)));
    }

    @Test
    public void testNormalElementsReport() {
        IntSetBins bins = new IntSetBins(15, 10);
        int[] elements = { 2, 3, 10, 4, 5, 7, 6, 1, 9, 8 };

        for (int element : elements) {
            bins.insert(element);
        }

        int[] reportedElement = new int[bins.size()];
        bins.report(reportedElement);

        // verify each sorted elements.
        Arrays.sort(elements);
        for (int i = 0; i < bins.size(); ++i) {
            assertThat(reportedElement[i], is(equalTo(elements[i])));
        }
    }

    @Test
    public void testReverseSortedElementsReport() {
        IntSetBins bins = new IntSetBins(15, 10);

        // insert elements from 10 to 0.
        for (int i = 10; i >= 0; --i) {
            bins.insert(i);
        }

        int[] reportedElement = new int[bins.size()];
        bins.report(reportedElement);

        // verify each sorted elements.
        for (int i = 0; i < 10; ++i) {
            assertThat(reportedElement[i], is(equalTo(i)));
        }
    }

    @Test
    public void testAlreadySortedElementsReport() {
        IntSetBins bins = new IntSetBins(100, 100);

        // insert elements from 0 to 100.
        for (int i = 0; i < 100; ++i) {
            bins.insert(i);
        }

        int[] reportedElement = new int[bins.size()];
        bins.report(reportedElement);

        // verify each sorted elements.
        for (int i = 0; i < 100; ++i) {
            assertThat(reportedElement[i], is(equalTo(i)));
        }
    }

    @Test
    public void testDuplicateElementsReport() {
        IntSetBins bins = new IntSetBins(15, 10);
        int[] elements = { 1, 4, 1, 4, 2, 3, 2, 3 };

        for (int element : elements) {
            bins.insert(element);
        }

        int[] reportedElement = new int[bins.size()];
        bins.report(reportedElement);

        assertThat(reportedElement[0], is(equalTo(1)));
        assertThat(reportedElement[1], is(equalTo(2)));
        assertThat(reportedElement[2], is(equalTo(3)));
        assertThat(reportedElement[3], is(equalTo(4)));
    }
}
