package oraclejava.classesandobjects.nested.nonstaticnested.anonymous;

public class Salary {
	private int base;
	private int overtime;
	
	public Salary(int base, int overtime) {
		this.base = base;
		this.overtime = overtime;
	}
	
	interface Payment {
		int calPay();
	}
	
	
	public Payment getPayment(double overtimeRadio) {
		return new Payment() {
			@Override
			public int calPay() {
				int overtimePay = (int)(overtime * (base / 31 * overtimeRadio));
				return base + overtimePay;
			}
		};
	}
	
	public static void main(String[] args) {
		Payment p = new Salary(100000, 5).getPayment(1.5);
		System.out.println("calPay : " + p.calPay());
		
		p = new Salary(100000, 5).getPayment(2.0);
		System.out.println("calPay : " + p.calPay());
	}
}
