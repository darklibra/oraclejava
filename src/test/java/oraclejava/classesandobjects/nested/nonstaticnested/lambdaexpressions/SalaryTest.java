package oraclejava.classesandobjects.nested.nonstaticnested.lambdaexpressions;

import oraclejava.classesandobjects.nested.nonstaticnested.lambdaexpressions.Salary.Payment;
import oraclejava.classesandobjects.nested.nonstaticnested.lambdaexpressions.Salary.Payment2;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by dain on 2015-11-04.
 */
public class SalaryTest {

    private Salary salary;

    @Before
    public void setUp() throws Exception {
        salary = new Salary(100000, 5);
    }

    @Test
    public void nested_static_class_ratio_one_point_five () {
        final Payment payment = salary.getPayment(1.5);
        final int expected = 124187;

        assertThat(payment.calPay()).isEqualTo(expected);
    }

    @Test
    public void nested_static_class_ratio_two () {
        final Payment payment = salary.getPayment(2.0);
        final int expected = 132250;

        assertThat(payment.calPay()).isEqualTo(expected);
    }

    @Test
    public void abbreviation () {
        final Payment noArgument = () -> {return 2000;};
        final Payment2 caseOne = e -> {return 1000 * e;};
        final Payment2 caseTwo = e -> 1000 * e;

        final int expected = 2000;

        assertThat(noArgument.calPay()).isEqualTo(expected);
        assertThat(caseOne.calPay(2)).isEqualTo(expected);
        assertThat(caseTwo.calPay(2)).isEqualTo(expected);
    }
}