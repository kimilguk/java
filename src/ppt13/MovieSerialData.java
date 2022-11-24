package ppt13;

import java.io.Serializable;
//클래스 데이터를 직렬화 하기 때문에 Serializable 인터페이스를 상속한다.
public class MovieSerialData implements Serializable {
	private String rank;//일별랭킹
	private String movieNm;//영화이름
	private String audiCnt;//일별관객수
	//get,set 을 사용하지 않고, 데이터를 입력하는 방법=생성자를 사용
	public MovieSerialData(String rank, String movieNm, String audiCnt) {
		this.rank = rank;
		this.movieNm = movieNm;
		this.audiCnt = audiCnt;
	}
	@Override
	public String toString() {
		return "MovieSerialData [rank=" + rank + ", movieNm=" + movieNm + ", audiCnt=" + audiCnt + "]";
	}
}
