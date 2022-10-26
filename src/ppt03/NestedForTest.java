package ppt03;

public class NestedForTest {

	public static void main(String[] args) {
		for(int x=0;x<5;x++) { //5행 반복
			for(int y=0;y<10;y++) {//10열 반복
				if(x==1 && y >= 5) {
					//내부 for문의 반복을 여기서 중지 하고 다음 반복 순서로 이동(아래)
					continue;//컨티뉴 명령 이후 부분 코드를 건너띄고, 다음 for순서로 
				}
				System.out.print("*");//가로로 10개 별표가 생성
			}
			//다음 행을 이동하기 전에 엔터
			System.out.println();//엔터 줄바꿈
		}

	}

}