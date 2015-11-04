package oraclejava.classesandobjects.nested.nonstaticnested;

public class Calcurator {
	private int l;
	private int r;
	
	public Calcurator(int l, int r) {
		this.l = l;
		this.r = r;
	}
	
	public class Result {
		public int add() {return l + r;}
		public int sub() {return l - r;}
	}
	
	public Result getResult() {
		return new Result();
	}
}
