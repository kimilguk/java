package ppt03;

import java.util.Scanner;

public class IfElseTest {
	public static void main(String[] args) {
		int number;
		Scanner input = new Scanner(System.in);
		// 반복시작 0부터 시작하기 때문에 5번이 실행된다.
		for (int i = 0; i < 5; i++) {
			System.out.print("양수,음수를 판별할 정수를 입력 하시오. 단 100을 입력하면  프로그램을 종료 합니다. ");
			number = input.nextInt();
			// 조건문 시작
			if (number > 0) {// 양수 일때 구현내용시작
				System.out.println("양수 입니다.");
				if(number == 100) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}
			}else if(number == 0) {
				System.out.println("0 입니다.");
			} else {//음수일 때 구현내용시작
				System.out.println("음수 입니다.");
			}
		}
		input.close();
	}
}