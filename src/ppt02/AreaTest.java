package ppt02;

class CircleArea {//원의 넓이를 구하는 기능의 클래스
	private int r;
	public CircleArea(int r) {//이클립스에서 생성자 메서드를 자동 생성 해 본다.
		this.r = r;
	}
	public CircleArea() {
		// 위 CircleArea(int r)생성자가 없다면, 컴파일시 자동으로 생성된다.
	}
	public double getArea() {
		return r*r*3.14;
	}
}
public class AreaTest {//실행 클래스
	public static void main(String[] args) {//아규먼트=Args=매개변수
		CircleArea cArea = new CircleArea(5);//파라미터=인자, 클래스형 변수 cArea는 객체이다.
		System.out.println("반지름이 5인 원의 넓이는 = "+ cArea.getArea());
		boolean bool = 1 < 2;
		System.out.println(bool);
		CircleArea cArea2 = new CircleArea();
		System.out.println("클래스를 초기화한 원의 넓이는 = "+ cArea2.getArea());
		int x = 3;
		double y = (double) x; //3.0 처럼 소수점이 붙어서 출력된다.
		System.out.println(y);
		y = 3.2;
		x = (int) y;//소수점이 없어진 3 이 출력된다.
		System.out.println(x);
	}
}
