package oraclejava.classesandobjects.nested.nonstaticnested.lambdaexpressions;

public class Salary {
	private int base;
	private int overtime;
	
	public Salary(int base, int overtime) {
		this.base = base;
		this.overtime = overtime;
	}
	
	@FunctionalInterface
	interface Payment {
		int calPay();
	}
	
	@FunctionalInterface
	interface Payment2 {
		int calPay(int overTime);
	}
	
	public Payment getPayment(double overtimeRadio) {
		return () -> {
			int overtimePay = (int)(overtime * (base / 31 * overtimeRadio));
			return base + overtimePay;
		};
	}

	public static void main(String[] args) {
		Payment p = new Salary(100000, 5).getPayment(1.5);
		System.out.println("calPay : " + p.calPay());
		
		p = new Salary(100000, 5).getPayment(2.0);
		System.out.println("calPay : " + p.calPay());
		
		Payment p2 = () -> {return 1000;};
		System.out.println("calPay : " + p2.calPay());
		
		Payment2 p3 = e -> {return 1000 * e;};
		System.out.println("calPay : " + p3.calPay(2));
		
		Payment2 p4 = e -> 1000 * e;
		System.out.println("calPay : " + p4.calPay(3));
	}
}
