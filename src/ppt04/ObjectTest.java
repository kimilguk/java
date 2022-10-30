package ppt04;

class ElectCalc {
	private double dx, dy;
	public ElectCalc() {
	}
	public ElectCalc(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}
	public void add() {	System.out.println("더하기 결과는 " + (dx+dy) );	}
	public void add(int x, int y, int z) { //오버로드 메서드 생성	
		System.out.println("더하기 결과는 " + (x+y+z) );	
	}
	public void sub() {	System.out.println("빼기 결과는 " + (dx-dy) );	}
	public void mul() {	System.out.println("곱하기 결과는 " + dx*dy);	}
	public void div() {	System.out.println("나누기 결과는 " + dx/dy);	}
	public void setDx(double dx) {
		this.dx = dx;
	}
	public void setDy(double dy) {
		this.dy = dy;
	}
}
public class ObjectTest {
	public static void main(String[] args) {
		ElectCalc electCalc = new ElectCalc();//실행 electCalc 객체생성
		electCalc.setDx(10);//메서드를 호출할때, 10,5 처럼 매개변수가 고정이 되지 않고,
		electCalc.setDy(5);//동적으로 묶이는방식을 동적바인딩이라고 함.
		electCalc.add();
		electCalc.add(1, 2, 3);//오버로드 기능 사용
		electCalc.sub();
		electCalc.mul();
		electCalc.div();
	}
}
