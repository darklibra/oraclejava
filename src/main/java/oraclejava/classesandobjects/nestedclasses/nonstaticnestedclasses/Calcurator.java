package oraclejava.classesandobjects.nestedclasses.nonstaticnestedclasses;

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
	
	public static void main(String[] args) {
		Result r = new Calcurator(10, 5).getResult();
		
		System.out.println(" add " + r.add());
		System.out.println(" sub " + r.sub());
	}
}
