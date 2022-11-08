package ppt07;

public class WrapperClassTest {
	public static void main(String[] args) {
		Integer intData = (Integer) 10;//명시적 박싱.(Integer)없이 값만 입력하면 오토박싱 처리 되었다고 한다.
		String stringData = Integer.toString(intData); //숫자를 문자열로 형 변환
		intData = Integer.valueOf(stringData);//문자열를 숫자로 형 변환
		System.out.println(intData + stringData);
		System.out.println(intData + Integer.valueOf(stringData));
	}
}