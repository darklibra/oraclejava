package oraclejava.oprators;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by dain on 2015-11-05.
 */
public class UnaryOperatorTest {
    private int source;

    @Before
    public void setUp() throws Exception {
        source = 2;
    }

    @Test
    public void right_increment() {
        final int expected = source;
        assertThat(source++).isEqualTo(expected);
        assertThat(source).isEqualTo(expected + 1);
    }

    @Test
    public void left_increment() {
        final int expected = source + 1;
        assertThat(++source).isEqualTo(expected);
    }

    @Test
    public void right_decrement() {
        final int expected = source;
        assertThat(source--).isEqualTo(expected);
        assertThat(source).isEqualTo(expected - 1);
    }

    @Test
    public void left_decrement() {
        final int expected = source - 1;
        assertThat(--source).isEqualTo(expected);
    }
}