package oraclejava.classesandobjects.nested.nonstaticnested.lambdaexpressions;

public class MethodAdd {
	@FunctionalInterface
	public interface Oprator {
		int op(int a, int b);
	}

	public static class Oprators {
		public static int add(int a, int b) {
			return a + b;
		}
		public static int sub(int a, int b) {
			return a - b;
		}
		public static int div(int a, int b) {
			return (int) (a / b);
		}
		public static int mod(int a, int b) {
			return a % b;
		}
		public static int multi(int a, int b) {
			return a * b;
		}
		public int nonStaticAdd(int a, int b) {
			return a + b;
		}
	}
}