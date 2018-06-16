package set;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class IntSetArrTest {
    @Test(expected = IllegalArgumentException.class)
    public void testCreateWithNegativeSize() {
        IntSetArr arr = new IntSetArr(-1, 0);
    }

    @Test
    public void testSetMaxElement() {
        IntSetArr arr = new IntSetArr(10, 100);
        assertThat(arr.getMaxElement(), is(equalTo(10)));
    }

    @Test
    public void testSetMaxValue() {
        IntSetArr arr = new IntSetArr(10, -1);
        assertThat(arr.getMaxValue(), is(equalTo(-1)));
    }

    @Test
    public void testNewarrSize() {
        IntSetArr arr = new IntSetArr(100, 100);
        assertThat(arr.size(), is(equalTo(0)));
    }

    @Test
    public void testInsert() {
        IntSetArr arr = new IntSetArr(100, 100);
        arr.insert(10);

        assertThat(arr.size(), is(equalTo(1)));
    }

    @Test
    public void testMultipleInsert() {
        IntSetArr arr = new IntSetArr(100, 100);

        for (int i = 0; i < 10; ++i) {
            arr.insert(i);
        }

        assertThat(arr.size(), is(equalTo(10)));
    }

    @Test
    public void testDuplicateInsert() {
        IntSetArr arr = new IntSetArr(100, 100);
        arr.insert(10);
        arr.insert(10);

        assertThat(arr.size(), is(equalTo(1)));
    }

    @Test
    public void testDuplicateMultipleInsert() {
        IntSetArr arr = new IntSetArr(100, 100);

        for (int i = 0; i < 10; ++i) {
            arr.insert(i);
            arr.insert(i);
        }

        assertThat(arr.size(), is(equalTo(10)));
    }

    @Test
    public void testOverMaxElementInsert() {
        IntSetArr arr = new IntSetArr(10, 100);

        for (int i = 0; i < 1000; ++i) {
            arr.insert(i);
        }

        assertThat(arr.size(), is(equalTo(10)));
    }

    @Test
    public void testOverMaxValueInsert() {
        IntSetArr arr = new IntSetArr(10, -1);

        for (int i = 0; i < 1000; ++i) {
            arr.insert(i);
        }

        assertThat(arr.size(), is(equalTo(0)));
    }

    @Test
    public void testNormalElementsReport() {
        IntSetArr arr = new IntSetArr(15, 10);
        int[] elements = { 2, 3, 10, 4, 5, 7, 6, 1, 9, 8 };

        for (int element : elements) {
            arr.insert(element);
        }

        int[] reportedElement = new int[arr.size()];
        arr.report(reportedElement);

        // verify each sorted elements.
        Arrays.sort(elements);
        for (int i = 0; i < arr.size(); ++i) {
            assertThat(reportedElement[i], is(equalTo(elements[i])));
        }
    }

    @Test
    public void testReverseSortedElementsReport() {
        IntSetArr arr = new IntSetArr(15, 10);

        // insert elements from 10 to 0.
        for (int i = 10; i >= 0; --i) {
            arr.insert(i);
        }

        int[] reportedElement = new int[arr.size()];
        arr.report(reportedElement);

        // verify each sorted elements.
        for (int i = 0; i < 10; ++i) {
            assertThat(reportedElement[i], is(equalTo(i)));
        }
    }

    @Test
    public void testAlreadySortedElementsReport() {
        IntSetArr arr = new IntSetArr(100, 100);

        // insert elements from 0 to 100.
        for (int i = 0; i < 100; ++i) {
            arr.insert(i);
        }

        int[] reportedElement = new int[arr.size()];
        arr.report(reportedElement);

        // verify each sorted elements.
        for (int i = 0; i < 100; ++i) {
            assertThat(reportedElement[i], is(equalTo(i)));
        }
    }

    @Test
    public void testDuplicateElementsReport() {
        IntSetArr arr = new IntSetArr(15, 10);
        int[] elements = { 1, 4, 1, 4, 2, 3, 2, 3 };

        for (int element : elements) {
            arr.insert(element);
        }

        int[] reportedElement = new int[arr.size()];
        arr.report(reportedElement);

        assertThat(reportedElement[0], is(equalTo(1)));
        assertThat(reportedElement[1], is(equalTo(2)));
        assertThat(reportedElement[2], is(equalTo(3)));
        assertThat(reportedElement[3], is(equalTo(4)));
    }
}
