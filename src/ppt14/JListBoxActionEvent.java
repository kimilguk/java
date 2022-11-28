package ppt14;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONObject;

public class JListBoxActionEvent extends JFrame implements ActionListener {
	private JTextField jTextField;
	private JList<Object> jListBox;
	private Vector<Map> movieListMap = new Vector<Map>(); //List 대신 Vector 배열객체를 사용
	private DefaultListModel listModel = new DefaultListModel(); //JList 컴포넌트의 내용 파싱용
	private JButton addBtn,deleteBtn;//원격 데이터서버 자료를 가져오는 이벤트용 버튼
	public JListBoxActionEvent() throws HeadlessException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("일별 영화박스오피스 정보 가져오기"); //이후 OpenAPI 시간에 구현예정
		jTextField = new JTextField("http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20220101");
		addBtn = new JButton("가져오기");
		deleteBtn = new JButton("지우기");
		jListBox = new JList<Object>();
		//스크롤 페인 스크롤이 있는 컨트이너를 만든다(아래)
		JScrollPane jPane = new JScrollPane(jListBox);//멀티라인 내용을 스크롤로 감싸주기
		//프레임에 컴포넌트 출력
		add(jTextField, BorderLayout.CENTER);
		add(addBtn, BorderLayout.WEST);
		add(deleteBtn, BorderLayout.EAST);
		//add(jTextArea, BorderLayout.SOUTH);
		add(jPane, BorderLayout.SOUTH); //스크롤페인 객체를 JFrame에 추가한다.
		pack();//자동크기조정(내부값에 따라서 자동으로 윈도우 프레임크기가 설정)
		setVisible(true);
		jTextField.addActionListener(this);//텍스트필드 액션이벤트 추가
		addBtn.addActionListener(this);//가져오기버튼 액션이벤트 추가
		deleteBtn.addActionListener(this);//지우기버튼 액션이벤트 추가
		jListBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//super.mouseReleased(e);
				int index = jListBox.getSelectedIndex();
				System.out.println(index);
				//아래 대화상자에서 this 대신 jPane컨테이너를 사용한다.
				JOptionPane.showMessageDialog(jPane, movieListMap.get(index));
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// 입력란에 엔터와 버튼을 눌렀을때 액션처리(아래)
		if(e.getSource()==addBtn || e.getSource()==jTextField) { //액션객체 비교
			String movieRanking = jTextField.getText();
			movieListMap.clear();//기존 데이터바인딩 초기화
			listModel.clear(); //기존 데이터바인딩 초기화
			//오픈API서비스 활용코드 추가(아래)먼저 OpenApi.java 의 serviceAPI 접근권한을 public으로변경
			OpenApi oApi = new OpenApi();
			try {
				JSONArray jArray = oApi.serviceAPI(movieRanking);
				for(Object object:jArray) {//배열객체에서 1개씩 객체를 가져온다. 
					JSONObject jObject = (JSONObject) object;
					//String[] movieInfo = movieRanking.split(",");
					Map<String, Object> movieMap = new HashMap<String, Object>();
					movieMap.put("rank", jObject.get("rank"));
					movieMap.put("movieNm", jObject.get("movieNm"));
					movieMap.put("audiCnt", jObject.get("audiCnt"));
					movieListMap.add(movieMap);
					listModel.addElement(String.valueOf(jObject.get("rank"))+jObject.get("movieNm"));
					jListBox.setModel(listModel); //jList 컴포넌트에 파싱 한 리스트 모델을 출력
				}
			} catch (Exception e1) {
				e1.printStackTrace(); //예외 발생 시 콘솔에 에러메세지 출력
			}
			for(Map movie:movieListMap) {
				System.out.println(movie);
			}
			//jListBox.setListData(movieListMap);
		}
		if(e.getSource()==deleteBtn) { //액션객체 비교
			int index = jListBox.getSelectedIndex();
			if(index > -1) {
				movieListMap.removeElementAt(index); //먼저 상세 데이터를 지운다.
				//jListBox.setListData(movieListMap); //리스트박스 값을 다시 바인딩 한다.
				listModel.removeElementAt(index); //먼저 파싱 데이터 지운다.
				jListBox.setModel(listModel); //파싱 데이터를 바인딩한다.
			}
			for(Map movie:movieListMap) {
				System.out.println(movie);
			}
		}
	}
	public static void main(String[] args) {
		new JListBoxActionEvent();
	}
}