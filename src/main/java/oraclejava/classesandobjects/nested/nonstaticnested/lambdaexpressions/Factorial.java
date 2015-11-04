package oraclejava.classesandobjects.nested.nonstaticnested.lambdaexpressions;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Factorial {
	
	public static void main(String[] args) {
		int num = 10;
		int p = 2;
		OptionalInt fac = IntStream.iterate(p, e -> e)
								   .limit(num)
								   .reduce((a, b) -> {
										int red = a * b;
										System.out.println(a + " * " + b + " = " + red);
										return red;
								   	});
		
		System.out.println(fac.getAsInt());
	}
}
