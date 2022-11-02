package ppt05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayListTest {

	public static class Movie {//영화정보 클래스
		private String title;//영화제목
		private String director;//영화감독
		private int runningTime;//상영시간(분)
		//get,set 을 사용하지 않고, 데이터를 입력하는 방법=생성자를 사용
		public Movie(String title, String director, int runningTime) {
			this.title = title;
			this.director = director;
			this.runningTime = runningTime;
		}
		@Override
		public String toString() {
			return "Movie [title=" + title + ", director=" + director + ", runningTime=" + runningTime + "]";
		}	
	}

	public static void main(String[] args) {
		//아래 결과가 데이터 전송에 특화된 Json형식이 아니다
		List<Movie> movieList = new ArrayList<Movie>();//배열객체 생성, 이 클래스는 java.util 패키지에 있다.
		movieList.add(new Movie("에일리언2", "제임스카메론", 120));
		movieList.add(new Movie("티파니에서 아침을", "에드워드 블레이크", 110));//입력
		System.out.println(movieList);//.toString() 생략된 상황
		
		//배열객체 생성(아래) 맵 데이터를 사용(Key,Value)
		Map<String, Object> movieMap1 = new HashMap<String, Object>();
		movieMap1.put("title", "에일리언2");
		movieMap1.put("director", "제임스카메론");
		movieMap1.put("runningTime", 120);
		Map<String, Object> movieMap2 = new HashMap<String, Object>();
		movieMap2.put("title", "티파니에서 아침을");
		movieMap2.put("director", "에드워드 블레이크");
		movieMap2.put("runningTime", 110);
		List<Map> movieMapList = new ArrayList<Map>();
		movieMapList.add(movieMap1);
		movieMapList.add(movieMap2);
		for(Map movieMap:movieMapList) {
			//System.out.println(movieMap); //개발자가 순서와 서식을 정할 수 없다. 그래서 아래 처럼 사용한다.
			System.out.println("title"+":"+movieMap.get("title"));
			System.out.println("director"+":"+movieMap.get("director"));
			System.out.println("runningTime"+":"+movieMap.get("runningTime"));
			System.out.println();
		}
		System.out.println(movieMapList);//표준 json에 맞게 배열객체 데이터 생성.
	}
}