package ppt14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class OpenApi {
	public static void main(String[] args) throws Exception {
		//영화진흥위원회의 일별 영화 박스오피스 요청 RestAPI URL을 입력
		String requestURL = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20220101";
		serviceAPI(requestURL);//RestAPI 서버에서 제이슨데이터를 가져오는 메서드. 
	}
	private static JSONArray serviceAPI(String requestURL) throws Exception {
		//URL에서 json데이터를 가져오는 구문(아래)
		BufferedReader bReader = null;
		URL url = new URL(requestURL);//스트링 url을 자바용 URL로 변경한다.
		HttpURLConnection hConnection = (HttpURLConnection) url.openConnection();//형변환
		hConnection.setRequestMethod("GET");//요청주소가 오픈된 주소 <-> POST 
		System.out.println("응답코드 확인: " + hConnection.getResponseCode());//정상 200
		//RestAPI 데이터를 읽어 들이기 버퍼드 리더로 문자열 읽어들이기
		bReader = new BufferedReader(new InputStreamReader(hConnection.getInputStream()));
		//버퍼에 들어 있는 데이터는 일렬로 되어 있는 시리얼 데이터 -> 토큰 데이터로 만들기(세로데이터)
		StringBuilder sBuilder = new StringBuilder();//토큰데이터 전체가 저장하는 객체 생성
		String line; //토큰 데이터가 들어갈 변수
		//반복문으로 한줄 데이터를 여러줄로 만든다
		while ((line = bReader.readLine()) != null) {
			sBuilder.append(line);//1줄 단위로 구성된 데이터를 누적한다.			
		}
		bReader.close(); //객체를 지운다.
		hConnection.disconnect(); //객체를 지운다.
		//아래 JSONObject 클래스 import 시 module-info.java 에 등록이 필요하다.(자바9이상)
		JSONObject jObject = new JSONObject(sBuilder.toString());//빌더의 토큰값을 json형태로 변경
		//System.out.println(jObject); //일단 출력결과 확인 json 데이터의 계층구조를 확인 한다.
		JSONObject boxOfficeResult = (JSONObject) jObject.get("boxOfficeResult");
		JSONArray dailyBoxOfficeList = (JSONArray) boxOfficeResult.get("dailyBoxOfficeList");
		//파싱 종료
		System.out.println(dailyBoxOfficeList); //일단 출력결과 확인
		return dailyBoxOfficeList;
	}
}
