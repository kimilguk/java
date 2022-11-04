package ppt06;

class Student extends SchoolUser{ //학교사용자중 학생 속성 저장클래스
	public String hakbun; //실무에서는 보통 private으로 한다.
	@Override
	public String toString() {
		return "Student [hakbun=" + hakbun + ", name=" + name + ", email=" + email + ", getAge()=" + getAge() + "]";
	}
}
class Staff extends SchoolUser{ //학교사용자중 교직원 속성 저장클래스
	public String sahun;
}
class Professor extends SchoolUser{ //학교사용자중 교수 속성 저장클래스
	public String major; //실무에서는 보통 private으로 한다.
	@Override
	public String toString() {
		return "Professor [major=" + major + ", name=" + name + ", email=" + email + ", getAge()=" + getAge() + "]";
	}
	public Professor() {
		//super(); //생략해도 자동 실행 된다.
		System.out.println("자식클래스 실행");
	}
}
class SchoolUser{ //학교사용자의 공통 속성들 저장클래스
	public String name;
	public String email;
	public SchoolUser() {
		System.out.println("부모클래스 실행");
	}
	private int age; //실무에서는 보통 private으로 한다.
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

public class ExtendsTest {
	public static void main(String[] args) {
		Student student = new Student();
		student.name = "학생명";
		student.email = "student@test.com";
		student.setAge(50);
		student.hakbun = "20230101";
		System.out.println(student.toString());
		Professor professor = new Professor();
		professor.name = "김일국";
		professor.email = "kimilguk@test.com";
		professor.setAge(100);
		professor.major = "AI융합";
		System.out.println(professor.toString());
	}
}
