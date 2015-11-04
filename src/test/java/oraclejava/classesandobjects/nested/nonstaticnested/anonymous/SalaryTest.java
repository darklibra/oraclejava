package oraclejava.classesandobjects.nested.nonstaticnested.anonymous;

import oraclejava.classesandobjects.nested.nonstaticnested.anonymous.Salary.Payment;
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
        final Payment payment = salary.getPaymentOnePointFive();
        final int expected = 124187;

        assertThat(payment.calPay()).isEqualTo(expected);
    }

    @Test
    public void nested_static_class_ratio_two () {
        final Payment payment = salary.getPaymentTwo();
        final int expected = 132250;

        assertThat(payment.calPay()).isEqualTo(expected);
    }
}