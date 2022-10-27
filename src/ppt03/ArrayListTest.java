package ppt03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayListTest {

	public static void main(String[] args) {
		//키:값 형태의 App의 데이터베이스 자료와 호환되는 방식
		Map<String,Object> memberMap1 = new HashMap<String,Object>();
		memberMap1.put("user_id", "admin");
		memberMap1.put("user_name", "관리자");
		memberMap1.put("email", "admin@abc.com");
		memberMap1.put("use", true);
		memberMap1.put("regdate", "2022-12-04");
		memberMap1.put("levels", "ROLE_ADMIN");
		Map<String,Object> memberMap2 = new HashMap<String,Object>();
		memberMap2.put("user_id", "user");
		memberMap2.put("user_name", "사용자1");
		memberMap2.put("email", "user@abc.com");
		memberMap2.put("use", false);
		memberMap2.put("regdate", "2022-12-04");
		memberMap2.put("levels", "ROLE_USER");
		//List<Map<String,Object>> memberMapList = new ArrayList<Map<String,Object>>();
		List<Map> memberMapList = new ArrayList<Map>();
		memberMapList.add(memberMap1);
		memberMapList.add(memberMap2);
		for(Map<String,Object> member:memberMapList) {//1개 레코드씩 member오브젝트객체로 대입
			System.out.println(member);
		}
	}

}
