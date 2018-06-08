import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class MainTest {
    @Test
    public void returnOneTest() {
        assertThat(Main.returnOne(), is(equalTo(1)));
    }
}
