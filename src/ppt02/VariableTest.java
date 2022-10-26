package ppt02;

public class VariableTest {
	//메모리 영역은 2가지 나뉜다. 1). static 고정영역: 미리 등록된 저장영역, 2). Heap 동적영역 : 객체화호출 시 등록되는 저장영역.
	static final String LETTER = "static:최초 앱 실행시 static영역에 고정으로 등록됨. 반대로 new키워드로 객체화시킨 변수는 호출시 히프영역에 동적으로 등록된다.";
	//final 키워드 : 현재 클래스에서 1번 등록하면 값을 변경하지 않고 사용한다는 의미 = 상수를 말한다.
	public static void main(String[] args) {
		//main 메서드는 자바프로그램의 시작지점을 명시한다. 
		System.out.println(LETTER);
		//변수는 크게 기초형과 참조형(클래스)로 구분한다.
		//기본형은 숫자(byte,short,int,long,float,double)
		int number1 = 100;//정수
		Integer num1 = new Integer(100); //취소선은 앞으로 자바에서 지원하지 않는다는 의미
		Integer num2 = 100;//위 처럼 긴 코드를 이 출처럼 간단하게 코딩한다.
		long number2 = 7000001000000L;//큰정수
		float number3 = 1f;//실수(소수점표시)
		double number4 = 1d;//큰실수, 아래 문자와 숫자를 더하면 문자로 인식된다.
		System.out.println("숫자형 : int="+number1+num1+num2+" long="+number2+" float="+number3+" double="+number4);
		//기초형 문자 char, 논리값 boolean
		char english = 'a';//주의! 작은따옴표만 가능하다.
		boolean logic = true;
		System.out.println("문자형 : char="+english+" boolean="+logic);
		
		//참조형은 Integer, Long, Double, Float, String, Boolean
		//기초형과 같은 데이터가 들어간다. 차이점은 클래스로 구성되고, null(공백) 값이 허용된다는 점이다. 
		//그래서, null Exception 이라는 예외처러가 필요한 프로그램에 많이 사용한다.
		String letter = "abc";//기본상속으로 java.lang.Object 사용하기 때문에 import 설정없이 사용가능하다.
		System.out.println("참조형 : "+letter);
		
		//본격적으로 클래스를 공부하기 전에 키워드에 대해서 학습
		//영역제한 허용 작은 크기순(private<default<protected<public)
		//위 상수 키워드가 붙지 않으면 일반변수:변수값을 여러번 수정이 가능하다.
		letter = "변수값 수정";
		System.out.println("참조형 : "+letter);
	}
}
