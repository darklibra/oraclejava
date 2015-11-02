package oraclejava.classesandobjects.EnumTypes.ruuner;

import oraclejava.classesandobjects.EnumTypes.EnumMethod;

public class EnumMethodRunner {
	public static void main(String[] args) {
		
		System.out.println("월요일? : " + EnumMethod.MONDAY.getWeekName());
		System.out.println("일요일? : " + EnumMethod.SUNDAY.getWeekName());
		
		EnumMethod mon = EnumMethod.MONDAY;
		System.out.println("월요일? : " + mon.getWeekName());
		
		EnumMethod sun = EnumMethod.SUNDAY;
		System.out.println("일요일? : " + sun.getWeekName());
	}
}
