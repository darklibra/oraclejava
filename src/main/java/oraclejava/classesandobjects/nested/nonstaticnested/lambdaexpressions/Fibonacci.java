package oraclejava.classesandobjects.nested.nonstaticnested.lambdaexpressions;

import com.google.common.collect.Lists;

import java.util.List;

public class Fibonacci {
	List<Integer> fiboList;

	public Fibonacci() {
        fiboList = Lists.newArrayList(0, 1, 1);
    }

	public Integer getFibo(int pos) {
		if (pos >= fiboList.size()) {
			Integer val = getFibo(pos-1) + getFibo(pos-2);
			fiboList.add(pos, val);
			return val;
		}
		
		return fiboList.get(pos);
	}
}
