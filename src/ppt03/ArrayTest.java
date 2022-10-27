package ppt03;

import java.util.Arrays;
import java.util.Collections;

public class ArrayTest {

	public static void main(String[] args) {
		Integer[] numbers = {11,21,31,41,51,61,71,81,91,101}; //배열 객체의 값을 초기화
		Arrays.sort(numbers, Collections.reverseOrder()); //역순 정렬
		System.out.println(numbers[0]+"~"+numbers[9]);
		for(int number : numbers) {
			 System.out.print(number+",");
		}
		System.out.println();//한 줄 띄우기
		for(int i=0; i<numbers.length; i++) {
			System.out.print(numbers[i]+ ",");
		}
	}

}
