package ppt07;

public class StringClassTest {
	public static void main(String[] args) {
		String s = "헬로 World!"; // 객체 생성
		int size = s.length(); // 9가 반환됨
		System.out.println(size);
		int index = s.indexOf("World");
		if(index == -1) { //인덱스는 0부터 시작하기 때문에 -1이면 검색값이 없다 
			System.out.println("World은 없습니다. ");
		}else {
			System.out.println("World의 위치: " + index);
		}
		String[] tokens = s.split(" ");//여기서 분리 규칙인 구분자는 공백 이다.
		for(String token:tokens) {
			System.out.println(token);
		}
	}
}
