package oraclejava.classesandobjects.EnumTypes.ruuner;

import oraclejava.classesandobjects.EnumTypes.EnumMethod;

public class EnumMethodRunner {
	public static void main(String[] args) {
		
		System.out.println("岿夸老? : " + EnumMethod.MONDAY.getWeekName());
		System.out.println("老夸老? : " + EnumMethod.SUNDAY.getWeekName());
		
		EnumMethod mon = EnumMethod.MONDAY;
		System.out.println("岿夸老? : " + mon.getWeekName());
		
		EnumMethod sun = EnumMethod.SUNDAY;
		System.out.println("老夸老? : " + sun.getWeekName());
	}
}
