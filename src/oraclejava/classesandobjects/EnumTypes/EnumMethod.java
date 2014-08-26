package oraclejava.classesandobjects.EnumTypes;

public enum EnumMethod {
	MONDAY("월요일"),
	SUNDAY("일요일");
	
	String weekname;
	private EnumMethod(String weekname) {
		this.weekname = weekname;
	}
	
	public String getWeekName() {
		return this.weekname;
	}
}
