package ppt13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializeTest {
	public static void main(String[] args) throws Exception {
		List<Movie> movieList,movieListOut;//직렬화와 역직렬화에서 사용
		movieList = new ArrayList<Movie>();
		movieList.add(new Movie("1", "에일리언", "120"));
		movieList.add(new Movie("2", "우주전쟁", "520"));
		//시리얼라이즈 저장
		FileOutputStream fos=new FileOutputStream("./src/movie.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(movieList); //객체를 직렬화 해서 파일에 저장
		//역직렬화 가져오기
		FileInputStream fis=new FileInputStream("./src/movie.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		movieListOut = new ArrayList<Movie>(); //가져온 데이터 저장용 빈 객체생성
		movieListOut = (List<Movie>) ois.readObject(); //역직렬화 애서 가져오기
		for(Movie movie:movieListOut) {
			System.out.println(movie);
		}
		oos.close(); //객체 삭제
		ois.close(); //메모리 초기화
	}
}
