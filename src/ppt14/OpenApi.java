package ppt14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenApi {
	public static void main(String[] args) throws Exception {
		//영화진흥위원회의 일별 영화 박스오피스 요청 RestAPI URL을 입력
		String requestURL = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20220101";
		serviceAPI(requestURL);//RestAPI 서버에서 제이슨데이터를 가져오는 메서드. 
	}
	private static void serviceAPI(String requestURL) throws Exception {
		//URL에서 json데이터를 가져오는 구문(아래)
		BufferedReader bReader = null;
		URL url = new URL(requestURL);//스트링 url을 자바용 URL로 변경한다.
		HttpURLConnection hConnection = (HttpURLConnection) url.openConnection();//형변환
		hConnection.setRequestMethod("GET");//요청주소가 오픈된 주소 <-> POST 
		System.out.println("응답코드 확인: " + hConnection.getResponseCode());//정상 200
		//RestAPI 데이터를 읽어 들이기 버퍼드 리더로 문자열 읽어들이기
		bReader = new BufferedReader(new InputStreamReader(hConnection.getInputStream()));
	}
}
