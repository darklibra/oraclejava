package oraclejava.classesandobjects.nested.nonstaticnested.lambdaexpressions;

import java.util.stream.IntStream;

public class Factorial {
	private int num;

    public Factorial(int num) {
        this.num = num;
    }

    public int get(int n) {
        return IntStream.iterate(this.num, e -> e)
                .limit(n)
                .reduce((a, b) -> a * b)
                .getAsInt();
    }
}
