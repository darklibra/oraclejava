package oraclejava.classesandobjects.nested.nonstaticnested;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by dain on 2015-11-04.
 */
public class CalcuratorTest {

    @Test
    public void calculate() {
        Calcurator.Result result = new Calcurator(10, 5).getResult();

        assertThat(result.add()).isEqualTo(15);
        assertThat(result.sub()).isEqualTo(5);
    }
}