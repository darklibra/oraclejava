package oraclejava.classesandobjects.EnumTypes;

public enum EnumMethod {
	MONDAY("월요일") {
        @Override
        boolean isSunday() {
            return false;
        }
    },
	SUNDAY("일요일") {
        @Override
        boolean isSunday() {
            return true;
        }
    };
	
	String weekname;
	private EnumMethod(String weekname) {
		this.weekname = weekname;
	}
	
	public String getWeekName() {
		return this.weekname;
	}

    abstract boolean isSunday();
}
