package oraclejava.classesandobjects.EnumTypes.ruuner;

import oraclejava.classesandobjects.EnumTypes.EnumMethod;

public class EnumMethodRunner {
	public static void main(String[] args) {
		
		System.out.println("������? : " + EnumMethod.MONDAY.getWeekName());
		System.out.println("�Ͽ���? : " + EnumMethod.SUNDAY.getWeekName());
		
		EnumMethod mon = EnumMethod.MONDAY;
		System.out.println("������? : " + mon.getWeekName());
		
		EnumMethod sun = EnumMethod.SUNDAY;
		System.out.println("�Ͽ���? : " + sun.getWeekName());
	}
}
