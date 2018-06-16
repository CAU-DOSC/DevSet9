package set;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class IntSetBitVectorTest {
    @Test(expected = IllegalArgumentException.class)
    public void testCreateWithNegativeSize() {
    	IntSetBitVector bitVector = new IntSetBitVector(-1, 0);
    }

    @Test
    public void testSetMaxElement() {
        IntSetBitVector bitVector = new IntSetBitVector(10, 100);
        assertThat(bitVector.getMaxElement(), is(equalTo(10)));
    }

    @Test
    public void testSetMaxValue() {
        IntSetBitVector bitVector = new IntSetBitVector(10, -1);
        assertThat(bitVector.getMaxValue(), is(equalTo(-1)));
    }

    @Test
    public void testNewbitVectorSize() {
        IntSetBitVector bitVector = new IntSetBitVector(100, 100);
        assertThat(bitVector.size(), is(equalTo(0)));
    }

    @Test
    public void testInsert() {
        IntSetBitVector bitVector = new IntSetBitVector(100, 100);
        bitVector.insert(10);

        assertThat(bitVector.size(), is(equalTo(1)));
    }

    @Test
    public void testMultipleInsert() {
        IntSetBitVector bitVector = new IntSetBitVector(100, 100);

        for (int i = 0; i < 10; ++i) {
            bitVector.insert(i);
        }

        assertThat(bitVector.size(), is(equalTo(10)));
    }

    @Test
    public void testDuplicateInsert() {
        IntSetBitVector bitVector = new IntSetBitVector(100, 100);
        bitVector.insert(10);
        bitVector.insert(10);

        assertThat(bitVector.size(), is(equalTo(1)));
    }

    @Test
    public void testDuplicateMultipleInsert() {
        IntSetBitVector bitVector = new IntSetBitVector(100, 100);

        for (int i = 0; i < 10; ++i) {
            bitVector.insert(i);
            bitVector.insert(i);
        }

        assertThat(bitVector.size(), is(equalTo(10)));
    }

    @Test
    public void testOverMaxElementInsert() {
        IntSetBitVector bitVector = new IntSetBitVector(10, 100);

        for (int i = 0; i < 1000; ++i) {
            bitVector.insert(i);
        }

        assertThat(bitVector.size(), is(equalTo(10)));
    }

    @Test
    public void testOverMaxValueInsert() {
        IntSetBitVector bitVector = new IntSetBitVector(10, -1);

        for (int i = 0; i < 1000; ++i) {
            bitVector.insert(i);
        }

        assertThat(bitVector.size(), is(equalTo(0)));
    }

    @Test
    public void testNormalElementsReport() {
        IntSetBitVector bitVector = new IntSetBitVector(15, 10);
        int[] elements = { 2, 3, 10, 4, 5, 7, 6, 1, 9, 8 };

        for (int element : elements) {
            bitVector.insert(element);
        }

        int[] reportedElement = new int[bitVector.size()];
        bitVector.report(reportedElement);

        // verify each sorted elements.
        Arrays.sort(elements);
        for (int i = 0; i < bitVector.size(); ++i) {
            assertThat(reportedElement[i], is(equalTo(elements[i])));
        }
    }

    @Test
    public void testReverseSortedElementsReport() {
        IntSetBitVector bitVector = new IntSetBitVector(15, 10);

        // insert elements from 10 to 0.
        for (int i = 10; i >= 0; --i) {
            bitVector.insert(i);
        }

        int[] reportedElement = new int[bitVector.size()];
        bitVector.report(reportedElement);

        // verify each sorted elements.
        for (int i = 0; i < 10; ++i) {
            assertThat(reportedElement[i], is(equalTo(i)));
        }
    }

    @Test
    public void testAlreadySortedElementsReport() {
        IntSetBitVector bitVector = new IntSetBitVector(100, 100);

        // insert elements from 0 to 100.
        for (int i = 0; i < 100; ++i) {
            bitVector.insert(i);
        }

        int[] reportedElement = new int[bitVector.size()];
        bitVector.report(reportedElement);

        // verify each sorted elements.
        for (int i = 0; i < 100; ++i) {
            assertThat(reportedElement[i], is(equalTo(i)));
        }
    }

    @Test
    public void testDuplicateElementsReport() {
        IntSetBitVector bitVector = new IntSetBitVector(15, 10);
        int[] elements = { 1, 4, 1, 4, 2, 3, 2, 3 };

        for (int element : elements) {
            bitVector.insert(element);
        }

        int[] reportedElement = new int[bitVector.size()];
        bitVector.report(reportedElement);

        assertThat(reportedElement[0], is(equalTo(1)));
        assertThat(reportedElement[1], is(equalTo(2)));
        assertThat(reportedElement[2], is(equalTo(3)));
        assertThat(reportedElement[3], is(equalTo(4)));
    }
}
