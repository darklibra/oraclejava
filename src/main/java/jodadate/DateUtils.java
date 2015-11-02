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
	
	public static int monthOfYear(LocalDate day) {
		if (day == null) throw new NullPointerException();
		return day.weekOfWeekyear().get();
	}
	
	public static boolean isNowMonth(LocalDate day) {
		LocalDate today = LocalDate.now(); 
		return today.weekOfWeekyear().equals(day.weekOfWeekyear());
	}
	
	public static boolean isNowMonthOfYear(LocalDate day) {
		return isSameMonthOfYear(LocalDate.now(), day);
	}
	
	public static boolean isSameMonthOfYear(LocalDate lDay, LocalDate rDay) {
		return monthOfYear(lDay) == monthOfYear(rDay);
	}
	
	public static LocalDate firstWeekOfWeekyear(LocalDate day) {
		return day.withDayOfWeek(MONDAY);
	}
	
	public static LocalDate lastWeekOfWeekyear(LocalDate day) {
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
	
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		
		// 이번주
		System.out.println(DateUtils.isNowWeekyear(today));
		System.out.println(DateUtils.isNowWeekyear(today.minusDays(7)));
		System.out.println("false? : " + DateUtils.isSameWeekyear(new LocalDate(2014, 8, 10), new LocalDate(2014, 8, 11)));
		System.out.println("true? : " + DateUtils.isSameWeekyear(new LocalDate(2014, 8, 11), new LocalDate(2014, 8, 12)));
		System.out.println("true? : " + DateUtils.isSameWeekyear(new LocalDate(2014, 8, 9), new LocalDate(2014, 8, 10)));
		System.out.println("true? : " + DateUtils.isSameWeekyear(new LocalDate(2014, 8, 10), new LocalDate(2014, 8, 9)));
		
		// 이번달
		System.out.println(DateUtils.isNowMonth(today));
		System.out.println(DateUtils.isNowMonth(today.minusMonths(1)));
		
		System.out.println("2014-08-01? : " + DateUtils.firstDateOfMonth(new LocalDate(2014, 8, 10)));
		System.out.println("2014-09-01? : " + DateUtils.firstDateOfMonth(new LocalDate(2014, 9, 15)));
		System.out.println("2014-02-01? : " + DateUtils.firstDateOfMonth(new LocalDate(2014, 2, 1)));
		
		System.out.println("2014-08-31? : " + DateUtils.lastDateOfMonth(new LocalDate(2014, 8, 10)));
		System.out.println("2014-09-30? : " + DateUtils.lastDateOfMonth(new LocalDate(2014, 9, 15)));
		System.out.println("2014-02-28? : " + DateUtils.lastDateOfMonth(new LocalDate(2014, 2, 1)));
		
		System.out.println("2014-09-15? : " + DateUtils.firstWeekOfWeekyear(new LocalDate(2014, 9, 15)));
		System.out.println("2014-08-11? : " + DateUtils.firstWeekOfWeekyear(new LocalDate(2014, 8, 13)));
		
		System.out.println("2014-09-21? : " + DateUtils.lastWeekOfWeekyear(new LocalDate(2014, 9, 15)));
		System.out.println("2014-08-17? : " + DateUtils.lastWeekOfWeekyear(new LocalDate(2014, 8, 13)));
		
	}	
}
