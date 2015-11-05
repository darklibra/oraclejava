package oraclejava.classesandobjects.EnumTypes;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Administrator on 2015-11-05.
 */
public class EnumMethodTest {
    @Test
    public void enum_variable () {
        final String strMonday = "월요일";
        final String strSunday = "일요일";

        assertThat(strMonday).isEqualTo(EnumMethod.MONDAY.getWeekName());
        assertThat(strSunday).isEqualTo(EnumMethod.SUNDAY.getWeekName());
    }

    @Test
    public void enum_method () {
        assertThat(EnumMethod.MONDAY.isSunday()).isFalse();
        assertThat(EnumMethod.SUNDAY.isSunday()).isTrue();
    }
}
