package oraclejava.classesandobjects.nested.staticnested;

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

		private static String toString(Member member) {
			return member.name + "#" + member.age;
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
		return MemberParser.toString(this);
	}
}
