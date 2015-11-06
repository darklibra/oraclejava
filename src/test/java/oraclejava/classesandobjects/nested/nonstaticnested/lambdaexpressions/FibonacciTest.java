package oraclejava.classesandobjects.nested.nonstaticnested.lambdaexpressions;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by dain on 2015-11-04.
 */
public class FibonacciTest {
    private Fibonacci fibo;

    @Before
    public void setUp() throws Exception {
        fibo = new Fibonacci();
    }

    @Test
    public void fibonacci () {
        List<Integer> expected = Lists.newArrayList(0, 1, 1, 2, 3, 5, 8);

        IntStream.range(0, expected.size())
                .forEach(e -> assertThat(expected.get(e)).isEqualTo(fibo.getFibo(e)));
    }
}