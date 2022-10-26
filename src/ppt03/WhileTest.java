package ppt03;

import java.util.Scanner;

public class WhileTest {

	public static void main(String[] args) {
		int n;//몇단을 출력할 건지 지정 변수
		int i = 1;
		Scanner input = new Scanner(System.in);
		System.out.print("구구단 중 출력하고 싶은 단을 입력하세요 ");
		n = input.nextInt();
		//while 무한반복문 시작
		while (i <= 9) {
			System.out.println(n + " x " + i + "=" + n*i);
			i = i+1;//i++
		}
		input.close();
	}

}