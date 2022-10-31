package ppt03;

public class ExternalClass {
	private int value;
	/* 생성자 메서드가 없어도 컴파일 시 자동 생성 되고, new 키워드로 객체 생성 시 value 값이 0으로 초기화 된다.
	public ExternalClass() {
		value = 0;
	}
	*/
	public void roll() { //주사위 굴리기 메서드 구현코드
		value = (int) (Math.random() * 6) + 1;//랜덤 함수가 0부터 시작하기 때문에 +1 처리
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
