package ppt03;

public class Array2DTest {

	public static void main(String[] args) {
		String [][] index = new String[2][6];//2행-row 6열-column 의 표 데이터를 저장 할 수 있다.
		String[][] members = {
						{"admin","관리자","admin@abc.com","true","2020-12-04","ROLE_ADMIN"},
						{"user","사용자1","user@abc.com","false","2020-12-04","ROLE_USER"}
		};
		 //구현 예(아래)
		System.out.println("======회원리스트 입니다.======");
		System.out.println("user_id | user_name | email | use | regdate | levels");
		for(String[] member:members) {
			System.out.println(member[0]+"|"+member[1]+"|"+member[2]+"|"+member[3]+ "|"+member[4]+"|"+member[5]);
		}
	}

}
