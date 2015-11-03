package jodadate;

import org.joda.time.LocalDate;
import org.joda.time.LocalDate.Property;

public class DateUtils {
	public final static int MONDAY = 1;
	public final static int SUNDAY = 7;
	
	public static boolean isToday(LocalDate day) {
		return LocalDate.now().equals(day);
	}
	
	public static int weekyear(LocalDate day) {
		if (day == null) throw new NullPointerException();
		return day.weekOfWeekyear().get();
	}
	
	public static boolean isNowWeekyear(LocalDate day) {
		return isSameWeekyear(LocalDate.now(), day); 
	}
	
	public static boolean isSameWeekyear(LocalDate lDay, LocalDate rDay) {
		return weekyear(lDay) == weekyear(rDay);
	}
	
	public static int month(LocalDate day) {
		if (day == null) throw new NullPointerException();
		return day.monthOfYear().get();
	}
	
	public static boolean isNowMonth(LocalDate day) {
		return isSameMonth(LocalDate.now(), day);
	}

	public static boolean isSameMonth(LocalDate lDay, LocalDate rDay) {
		return month(lDay) == month(rDay);
	}

	public static LocalDate firstDateOfWeek(LocalDate day) {
		return day.withDayOfWeek(MONDAY);
	}
	
	public static LocalDate lastDateOfWeek(LocalDate day) {
		return day.withDayOfWeek(SUNDAY);
	}
	
	public static LocalDate firstDateOfMonth(LocalDate day) {
		Property property = day.dayOfMonth();
		return day.withDayOfMonth(property.getMinimumValue());
	}
	
	public static LocalDate lastDateOfMonth(LocalDate day) {
		Property property = day.dayOfMonth();
		return day.withDayOfMonth(property.getMaximumValue());
	}
}
