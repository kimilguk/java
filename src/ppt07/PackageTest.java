package ppt07;

import ppt06.ImplementsCalc;

public class PackageTest {
	//다른 패키지의 클래스를 가져와서 객체로 만들어 기능을 실행해 본다.
	public static void main(String[] args) {
		ImplementsCalc AllCalc = new ImplementsCalc();
		AllCalc.add(10, 10);
	}
}
