package oraclejava.classesandobjects.nestedclasses.nonstaticnestedclasses.lambdaexpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Supplier;

public class MethodAdd {
	@FunctionalInterface
	interface Oprator {
		int op(int a, int b);
	}
	
	public static int add(int a, int b) {
		return a + b;
	}
	
	public static class Oprators {
		public int a = 1;
		
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
	
	public static int cal(Oprator op) {
		return op.op(650, 300);
	}
	
	public static <T, DEST extends Collection<T>> void printOp(Supplier<DEST> list) {
		System.out.println(list);
	}
	
	public static void main(String[] args) {
		System.out.println("add : " + cal(Oprators::add));
		System.out.println("sub : " + cal(Oprators::sub));
		System.out.println("div : " + cal(Oprators::div));
		System.out.println("mod : " + cal(Oprators::mod));
		System.out.println("multi : " + cal(Oprators::multi));
		
		// 클래스 인스턴스::NonStatic 함수
		Oprators op = new Oprators();
		System.out.println("nonStaticAdd : " + cal(op::nonStaticAdd));
		
		// 클래스::NonStatic 함수
		String[] stringArray  = {"bar", "temp" };
		Arrays.sort(stringArray, String::compareToIgnoreCase);
		
		// 생성자를 호출
		printOp(ArrayList<Integer>::new);
	}
}