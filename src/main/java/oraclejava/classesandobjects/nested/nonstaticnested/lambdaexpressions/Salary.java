package oraclejava.classesandobjects.nested.nonstaticnested.lambdaexpressions;

public class Salary {
	private int base;
	private int overtime;
	
	public Salary(int base, int overtime) {
		this.base = base;
		this.overtime = overtime;
	}
	
	@FunctionalInterface
	public interface Payment {
		int calPay();
	}
	
	@FunctionalInterface
	public interface Payment2 {
		int calPay(int overTime);
		// int calPay(); // error
	}
	
	public Payment getPayment(double overtimeRadio) {
		return () -> base + (int)(overtime * (base / 31 * overtimeRadio));
	}
}
