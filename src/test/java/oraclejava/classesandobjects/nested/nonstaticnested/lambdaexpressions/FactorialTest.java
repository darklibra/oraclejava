package oraclejava.classesandobjects.nested.nonstaticnested.lambdaexpressions;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by dain on 2015-11-04.
 */
public class FactorialTest {
    private Factorial factorial;

    @Before
    public void setUp() throws Exception {
        factorial = new Factorial(2);
    }

    @Test
    public void test () {
        assertThat(factorial.get(2)).isEqualTo(4);
        assertThat(factorial.get(3)).isEqualTo(8);
        assertThat(factorial.get(4)).isEqualTo(16);
        assertThat(factorial.get(5)).isEqualTo(32);
        assertThat(factorial.get(6)).isEqualTo(64);
        assertThat(factorial.get(7)).isEqualTo(128);
        assertThat(factorial.get(8)).isEqualTo(256);
        assertThat(factorial.get(9)).isEqualTo(512);
        assertThat(factorial.get(10)).isEqualTo(1024);
    }
}