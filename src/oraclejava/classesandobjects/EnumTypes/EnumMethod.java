package oraclejava.classesandobjects.EnumTypes;

public enum EnumMethod {
	MONDAY("������"),
	SUNDAY("�Ͽ���");
	
	String weekname;
	private EnumMethod(String weekname) {
		this.weekname = weekname;
	}
	
	public String getWeekName() {
		return this.weekname;
	}
}
