package oraclejava.classesandobjects.nested.nonstaticnested.lambdaexpressions;

import oraclejava.classesandobjects.nested.nonstaticnested.lambdaexpressions.MethodAdd.Oprator;
import oraclejava.classesandobjects.nested.nonstaticnested.lambdaexpressions.MethodAdd.Oprators;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by dain on 2015-11-04.
 */
public class MethodAddTest {
    final static private int LEFT_VALUE = 100;
    final static private int RIGHT_VALUE = 100;

    private Salary salary;

    @Before
    public void setUp() throws Exception {
        salary = new Salary(100000, 5);
    }

    public static int staticCal(Oprator op) {
        return op.op(LEFT_VALUE, RIGHT_VALUE);
    }

    public static <T, DEST extends Collection<T>> boolean isNull(Supplier<DEST> list) {
        return Objects.isNull(list);
    }

    @Test
    public void static_function_parameter () {
        assertThat(staticCal(Oprators::add)).isEqualTo(LEFT_VALUE + RIGHT_VALUE);
        assertThat(staticCal(Oprators::sub)).isEqualTo(LEFT_VALUE - RIGHT_VALUE);
        assertThat(staticCal(Oprators::div)).isEqualTo(LEFT_VALUE / RIGHT_VALUE);
        assertThat(staticCal(Oprators::mod)).isEqualTo(LEFT_VALUE % RIGHT_VALUE);
        assertThat(staticCal(Oprators::multi)).isEqualTo(LEFT_VALUE * RIGHT_VALUE);
    }

    @Test
    public void non_static_function_parameter () {
        Oprators op = new Oprators();

        assertThat(staticCal(op::nonStaticAdd)).isEqualTo(LEFT_VALUE + RIGHT_VALUE);

        // TODO : 두 기능 차이 확인 필요..
        // assertThat(staticCal(Oprators::nonStaticAdd)).isEqualTo(LEFT_VALUE + RIGHT_VALUE);
        // Arrays.sort(new String[]{"bar", "temp"}, String::compareToIgnoreCase);
    }

    @Test
    public void call_construct () {
        assertThat(isNull(null)).isTrue();
        assertThat(isNull(ArrayList<Integer>::new)).isFalse();
    }

}