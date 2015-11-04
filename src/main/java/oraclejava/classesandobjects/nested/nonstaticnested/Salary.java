package oraclejava.classesandobjects.nested.nonstaticnested;

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
	
	public class SalaryPayment implements Payment {
		@Override
		public int calPay() {
			int overtimePay = (int)(overtime * (base / 31 * 1.5));
			return base + overtimePay;
		}
	}
	
	public Payment getPayment() {
		return new SalaryPayment();
	}
	
	public static void main(String[] args) {
		Payment p = new Salary(100000, 5).getPayment();
		System.out.println("calPay : " + p.calPay());
	}
}
