package ppt06;

public class InterfaceTest {
	public static void main(String[] args) {
		// 자바프로그램은 항상 main() 진입점에서 실행하시는 겁니다. 단, 웹프로그램은 해당않됨.
		ImplementsCalc allCalc = new ImplementsCalc();//실행 오브젝트변수 allCalc 생성
		allCalc.add(5, 5);//메서드를 호출할때, 5,5 / 10,10 이렇게 매개변수가 고정이 되지 않고,
		allCalc.sub(10, 10);//동적으로 묶이는방식을 동적바인딩이라고 함.
		allCalc.mul(5, 5);
		allCalc.div(5, 5);
	}
}
