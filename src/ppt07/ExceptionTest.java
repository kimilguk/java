package ppt07;

public class ExceptionTest {
	public static void main(String[] args) {
        int x = 10, y = 0;
		int[] a = {1, 2, 3};
		try {
			int z = x/y;//1번째 에러 처리
			z = a[4];//2번째 에러 처리
		} catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("에러와 상관없이 무조건 실행되는 영역");
		}
	}
}