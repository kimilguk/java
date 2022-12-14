package ppt05;

class Singleton{//앱 실행시 이 클래스는 내부에 new 키워드로 객체가 이미 생성되게 함. 
	private static Singleton instance; //static이라서 고정 메모리 영역을 사용  
	private Singleton(){} // private이라서 외부 클래스에서 new로 객체 생성 불가
	public static Singleton getInstance(){ // getInstance 메서드 정의
		if (instance == null) { //이 조건 때문에 1번만 객체화가 된다.
			instance = new Singleton();
		}
		return instance; // instance 객체 리턴
	}
}
public class SingletonTest {
	public static void main(String[] args) {
		Singleton st1 = Singleton.getInstance(); // 싱글톤 인스턴스 호출
		Singleton st2 = Singleton.getInstance();
//		Singleton st3 = new Singleton(); // 생성자 이용 인스턴스 생성 불가
		if(st1 == st2){//객체와 숫자는 == 로 비교.단, 문자열 비교는 "문자".equals("비교값")처럼 비교한다.
			System.out.println("동일 객체");//싱클톤 객체일 때 동일한 객체이다.메모리 자원을 효율적으로 사용가능하다.
		}else{
			System.out.println("다른 객체");//new 키워드로 객체를 생성하면 다른 객체이다.
		}
	}
}
