package oraclejava.classesandobjects.nested.nonstaticnested.lambdaexpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Fibonacci {
	List<Integer> fiboList;
	{
		fiboList = new ArrayList<Integer>();
		fiboList.add(0, 0);
		fiboList.add(1, 1);
		fiboList.add(2, 1);
	}
	
	private Integer getFibo(int pos) {
		if (pos >= fiboList.size()) {
			Integer val = getFibo(pos-1) + getFibo(pos-2);
			fiboList.add(pos, val);
			return val;
		}
		
		return fiboList.get(pos);
	}
	
	public static void main(String[] args) {
		Fibonacci fibo = new Fibonacci();
		
		IntStream.range(1, 10)
				 .map(fibo::getFibo)
				 .forEach(System.out::println);
	}
}
