package jodadate;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Administrator on 2015-11-02.
 */
public class DateUtilsTest {
    private LocalDate firstDayOfYear;
    private LocalDate lastDayOfYear;
    private LocalDate today;

    @Before
    public void setUp() {
        firstDayOfYear = new LocalDate(2015, 1, 1);
        lastDayOfYear = new LocalDate(2015, 12, 31);
        today = LocalDate.now();
    }

    @Test
    public void is_today() {
        assertThat(DateUtils.isToday(today)).isTrue();
        assertThat(DateUtils.isToday(today.minusDays(1))).isFalse();
    }

    @Test
    public void is_now_weekyear() {
        assertThat(DateUtils.isNowWeekyear(today)).isTrue();
    }

    @Test
    public void weekyear() {
        final int expected = 1;

        assertThat(DateUtils.weekyear(firstDayOfYear)).isEqualTo(expected);
    }

    @Test
    public void is_same_weekyear() {
        final LocalDate monday = new LocalDate(2015, 1, 5);
        final LocalDate sunday = new LocalDate(2015, 1, 11);
        final LocalDate previousSunday = monday.minusDays(1);
        final LocalDate nextMonday = sunday.plusDays(1);

        assertThat(DateUtils.isSameWeekyear(monday, sunday)).isTrue();
        assertThat(DateUtils.isSameWeekyear(monday, new LocalDate(2014, 1, 6))).isTrue();
        assertThat(DateUtils.isSameWeekyear(previousSunday, sunday)).isFalse();
        assertThat(DateUtils.isSameWeekyear(monday, nextMonday)).isFalse();
    }

    @Test
    public void is_now_month() {
        assertThat(DateUtils.isNowMonth(today)).isTrue();
        assertThat(DateUtils.isNowMonth(today.minusMonths(1))).isFalse();
        assertThat(DateUtils.isNowMonth(today.minusYears(1))).isTrue();
    }

    @Test
    public void is_same_month_of_year() {
        final LocalDate previousMonth = firstDayOfYear.minusMonths(1);
        final LocalDate nextMonth = firstDayOfYear.minusMonths(1);

        assertThat(DateUtils.isSameMonth(firstDayOfYear, new LocalDate(2014, 1, 31))).isTrue();
        assertThat(DateUtils.isSameMonth(firstDayOfYear, previousMonth)).isFalse();
        assertThat(DateUtils.isSameMonth(firstDayOfYear, nextMonth)).isFalse();
    }

    @Test
    public void first_date_of_month() {
        assertThat(DateUtils.firstDateOfMonth(new LocalDate(2015, 1, 2))).isEqualTo(firstDayOfYear);
        assertThat(DateUtils.firstDateOfMonth(new LocalDate(2015, 1, 15))).isEqualTo(firstDayOfYear);
        assertThat(DateUtils.firstDateOfMonth(new LocalDate(2015, 1, 31))).isEqualTo(firstDayOfYear);
    }

    @Test
    public void last_date_of_month() {
        assertThat(DateUtils.lastDateOfMonth(new LocalDate(2015, 12, 1))).isEqualTo(lastDayOfYear);
        assertThat(DateUtils.lastDateOfMonth(new LocalDate(2015, 12, 15))).isEqualTo(lastDayOfYear);
        assertThat(DateUtils.lastDateOfMonth(new LocalDate(2015, 12, 30))).isEqualTo(lastDayOfYear);
    }

    @Test
    public void first_date_of_week() {
        final LocalDate expected = new LocalDate(2014, 12, 29);
        final LocalDate lastDateOfWeek = new LocalDate(2015, 1, 4);

        assertThat(DateUtils.firstDateOfWeek(firstDayOfYear)).isEqualTo(expected);
        assertThat(DateUtils.firstDateOfWeek(lastDayOfYear.minusYears(1))).isEqualTo(expected);
        assertThat(DateUtils.firstDateOfWeek(lastDateOfWeek)).isEqualTo(expected);
    }

    @Test
    public void last_date_of_week() {
        final LocalDate expected = new LocalDate(2015, 1, 4);
        final LocalDate firstDateOfWeek = new LocalDate(2014, 12, 29);

        assertThat(DateUtils.lastDateOfWeek(firstDayOfYear)).isEqualTo(expected);
        assertThat(DateUtils.lastDateOfWeek(lastDayOfYear.minusYears(1))).isEqualTo(expected);
        assertThat(DateUtils.lastDateOfWeek(firstDateOfWeek)).isEqualTo(expected);
    }

    @Test
    public void month() {
        final int expected = 1;

        assertThat(DateUtils.month(firstDayOfYear)).isEqualTo(expected);
    }
}