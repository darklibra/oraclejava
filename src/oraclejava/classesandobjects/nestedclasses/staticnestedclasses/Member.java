package oraclejava.classesandobjects.nestedclasses.staticnestedclasses;

public class Member {
	private String name;
	private int age;
	
	public static class MemberParser {
		public static Member paser() {
			Member m = new Member();
			m.name = "test";
			m.age = 10;
			return m;
		}
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}	
	
	public static void main(String[] args) {
		MemberParser mp = new MemberParser();
		Member m = mp.paser();
		
		System.out.println("name : " + m.getName());
		System.out.println("age : " + m.getAge());
	}
}
