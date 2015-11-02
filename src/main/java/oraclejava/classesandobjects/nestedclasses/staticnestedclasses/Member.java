package oraclejava.classesandobjects.nestedclasses.staticnestedclasses;

public class Member {
	private String name;
	private int age;
	
	private Member() {}
	
	public static class MemberParser {
		// TODO : 인자를 받아서 잘라서 보내주는 코드를 추가 예정
		public static Member parser(String data) {
			String[] datas = data.split("#");
			Member m = new Member();
			m.name = datas[0];
			m.age = Integer.valueOf(datas[1]);
			return m;
		}
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}	
	
	@Override
	public String toString() {
		return name + "#" + age;
	}

	public static void main(String[] args) {
		String data = "Values#100";
		Member m = MemberParser.parser(data);
		
		System.out.println("name : " + m.getName());
		System.out.println("age : " + m.getAge());
		
		System.out.println("data(" + data + ") == m(" + m + ") ? " + data.equals(m.toString()));
	}
}
