package ppt06;

//넓이를 구하는 공식으로 필요한 멤버변수를 구하고 도형을 그릴 수 있다.
class Rectangle extends Shape {
	private int width, height; //가로x세로 = 넓이
	@Override
	protected void draw() {
		System.out.println("사각형 그리기");
	}
}
class Circle extends Shape {
	private int radius; //반지름x반지금x3.14 = 넓이
	@Override
	protected void draw() {
		System.out.println("원 그리기");
	}
}
abstract class Shape {
	private int x, y; //시작 좌표점은 모든 도형그리기에 공통으로 사용하는 속성이다.
	protected abstract void draw(); //구현내용이 없는 메서드 목차만 존재한다.
}
public class AbstractTest {
	public static void main(String[] args) {
		Shape rectangle, circle;
		rectangle = new Rectangle(); //상속한 객체의 draw메서드를 실행
		rectangle.draw();
		circle = new Circle(); //상속한 객체의 draw메서드를 실행
		circle.draw();
	}
}
