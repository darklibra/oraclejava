package jodadate;

import org.joda.time.LocalDate;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Administrator on 2015-11-02.
 */
public class DateUtilsTest {

    @Test
    public void is_today() {
        LocalDate today = LocalDate.now();

        assertThat(DateUtils.isToday(today)).isTrue();
        assertThat(DateUtils.isToday(today.minusDays(1))).isFalse();
    }

    @Test
    public void is_now_weekyear() {
        LocalDate today = LocalDate.now();

        assertThat(DateUtils.isNowWeekyear(today)).isTrue();
    }

    @Test
    public void weekyear() {
        LocalDate firstDayOfYear = new LocalDate(2015, 1, 1);

        assertThat(DateUtils.weekyear(firstDayOfYear)).isEqualTo(1);
    }

    @Test
    public void is_same_weekyear() {
        LocalDate monday = new LocalDate(2015, 1, 5);
        LocalDate sunday = new LocalDate(2015, 1, 11);

        assertThat(DateUtils.isSameWeekyear(monday, sunday)).isTrue();


        LocalDate previousSunday = monday.minusDays(1);
        assertThat(DateUtils.isSameWeekyear(previousSunday, sunday)).isFalse();


        LocalDate nextMonday = sunday.plusDays(1);
        assertThat(DateUtils.isSameWeekyear(monday, nextMonday)).isFalse();
    }
}