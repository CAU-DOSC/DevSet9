package set;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class IntSetListTest {
    @Test(expected = IllegalArgumentException.class)
    public void testCreateWithNegativeSize() {
        IntSetList list = new IntSetList(-1, 0);
    }

    @Test
    public void testSetMaxElement() {
        IntSetList list = new IntSetList(10, 100);
        assertThat(list.getMaxElement(), is(equalTo(10)));
    }

    @Test
    public void testSetMaxValue() {
        IntSetList list = new IntSetList(10, -1);
        assertThat(list.getMaxValue(), is(equalTo(-1)));
    }

    @Test
    public void testNewListSize() {
        IntSetList list = new IntSetList(100, 100);
        assertThat(list.size(), is(equalTo(0)));
    }

    @Test
    public void testInsert() {
        IntSetList list = new IntSetList(100, 100);
        list.insert(10);

        assertThat(list.size(), is(equalTo(1)));
    }

    @Test
    public void testMultipleInsert() {
        IntSetList list = new IntSetList(100, 100);

        for (int i = 0; i < 10; ++i) {
            list.insert(i);
        }

        assertThat(list.size(), is(equalTo(10)));
    }

    @Test
    public void testDuplicateInsert() {
        IntSetList list = new IntSetList(100, 100);
        list.insert(10);
        list.insert(10);

        assertThat(list.size(), is(equalTo(1)));
    }

    @Test
    public void testDuplicateMultipleInsert() {
        IntSetList list = new IntSetList(100, 100);

        for (int i = 0; i < 10; ++i) {
            list.insert(i);
            list.insert(i);
        }

        assertThat(list.size(), is(equalTo(10)));
    }
}
