package ppt07;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class LibraryClassTest {
	public static void main(String[] args) {
		/* StringBuffer클래스의 메서드사용(아래)*/
		StringBuffer sb = new StringBuffer("10+20=");
		sb.append(10+20); //sb객체값에 append로 확장해서 계산결과를 붙인다. 
		sb.insert(0, "수식 "); //sb객체값의 0번째 인덱스에 단어를 붙인다.
		System.out.println(sb);
		/* Math클래스의 메서드사용(아래) */
		float y = (float)Math.PI; //3.1415927 
		System.out.println(y);
		//구글 사이트에서 검증 편의를 위해 double 에서 float로 형 변환을 한다. 
        System.out.println((float)Math.log10(y));//y=10^x지수함수와 대칭 x = log10y로그함수
        Random random = new Random();
        //1부터 10까지 총 10개의 무작위 수를 출력한다.
        for (int i = 1; i <= 10; i++) {
        	System.out.print(random.nextInt(10)+1+",");
        }
        System.out.println();
        /* Arrays클래스의 정렬 메서드사용(아래) */
        Integer[] array = {9, 4, 5, 6, 2, 1};
		Arrays.sort(array); //오름차순으로 정렬
		//Arrays.sort(array,Collections.reverseOrder());//내림차순 정렬
		printArray(array);
		System.out.println();
		System.out.println(Arrays.binarySearch(array, 9));//9의 인덱스값을 구하는 함수.
		Arrays.fill(array, 8);//배열의 내용을 초기화 할때 사용.
		printArray(array);
	}
	private static void printArray(Integer[] array) {
		for(int result:array) {
			System.out.print(result + " ");
		}
	}
}
