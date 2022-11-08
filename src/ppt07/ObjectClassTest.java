package ppt07;

public class ObjectClassTest {
	public static class Car {
		@Override
		public String toString() { //아래 super는 Object 클래스를 말한다.
			return "Car [toString()=" + super.toString() + "]";
		}
	}
	public static void main(String[] args) {
		//1. equals: 객체의 값 비교에 사용
		String s1 = "김일국";
		String s2 = new String("김일국");
		if(s1==s2) { //객체의 주소비교
			System.out.println("동일한 객체이다.");
		}else {
			System.out.println("동일한 객체가 아니다.");
		}
		if(s1.equals(s2)) { //겍체의 저장된 값비교
			System.out.println("객체에 저장된 값이 동일하다.");
		}else {
			System.out.println("객체에 저장된 값이 틀리다.");
		}
		Car car = new Car();
		System.out.println("객체에 저장된 값은 " + car.toString());
		System.out.println("객체의 클래스 이름은 " + car.getClass().getName());
	}

}
