package oraclejava.classesandobjects.nested.nonstaticnested.anonymous;

public class Salary {
	private int base;
	private int overtime;
	
	public Salary(int base, int overtime) {
		this.base = base;
		this.overtime = overtime;
	}
	
	public interface Payment {
		int calPay();
	}

	public Payment getPaymentOnePointFive() {
		return new Payment() {
			@Override
			public int calPay() {
				int overtimePay = (int)(overtime * (base / 31 * 1.5));
				return base + overtimePay;
			}
		};
	}

	public Payment getPaymentTwo() {
		return new Payment() {
			@Override
			public int calPay() {
				int overtimePay = (int)(overtime * (base / 31 * 2.0));
				return base + overtimePay;
			}
		};
	}
}
