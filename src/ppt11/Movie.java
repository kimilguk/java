package ppt11;

public class Movie { //일별 박스오피스 영화정보 클래스
	private String rank;//일별랭킹
	private String movieNm;//영화이름
	private String audiCnt;//일별관객수
	//get,set 을 사용하지 않고, 데이터를 입력하는 방법=생성자를 사용
	public Movie(String rank, String movieNm, String audiCnt) {
		this.rank = rank;
		this.movieNm = movieNm;
		this.audiCnt = audiCnt;
	}
}
