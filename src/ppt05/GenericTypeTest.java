package ppt05;

class Box<T> { //T라는 변수를 파라미터로 갖는 클래스를 만든다.
	private T data;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
public class GenericTypeTest {
	public static void main(String[] args) {
		Box<Integer> box1 = new Box<Integer>();
		box1.setData(100);//정수 100을 저장
		System.out.println("Box객체에 숫자를 저장한 값은 " + box1.getData());
		Box<String> box2 = new Box<String>();
		box2.setData("제네릭타입 클래스를 만들다");
		System.out.println("Box객체에 문자를 저장한 값은 " + box2.getData());
	}
}
