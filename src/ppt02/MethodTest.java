package ppt02;

import java.util.Scanner;

public class MethodTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("화씨온도를 입력하시오: ");
		double f = sc.nextDouble();
		sc.close();//객체를 메모리에서 제거하는 개발자가 메모리 사용 관리를 하는 코딩을 추가한다.
		double c_temp;
		c_temp = ftoc(f);//화시 212F도는 섭씨 100C도이다.
		System.out.println("섭씨온도는 "+c_temp);
	}
	//화씨 온도를 섭씨 온도로 변환하는 메서드
	private static double ftoc(double f) {
		return 5.0/9.0 *(f-32.0);
	}
}
