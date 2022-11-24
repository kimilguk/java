package ppt11;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class JComboBoxActionEvent extends JFrame implements ActionListener {
	private JTextField jTextField;
	private JComboBox<Object> jComboBox;
	private List<Map> movieListMap = new ArrayList<Map>(); //추가한 내용 리스트맵 객체에 저장
	private boolean toggle = false; //상세정보 액션이 최초에는 실행되지 않게 한다.
	private JButton addBtn,deleteBtn;//원격 데이터서버 자료를 가져오는 이벤트용 버튼
	public JComboBoxActionEvent() throws HeadlessException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("일별 영화박스오피스 정보 가져오기"); //이후 OpenAPI 시간에 구현예정
		jTextField = new JTextField("1, 에일리언, 120");
		addBtn = new JButton("가져오기");
		deleteBtn = new JButton("지우기");
		jComboBox = new JComboBox<Object>();
		//스크롤 페인 스크롤이 있는 컨트이너를 만든다(아래)
		JScrollPane jPane = new JScrollPane(jComboBox);//멀티라인 내용을 스크롤로 감싸주기
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
		jComboBox.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// 입력란에 엔터와 버튼을 눌렀을때 액션처리(아래)
		if(e.getSource()==addBtn || e.getSource()==jTextField) { //액션객체 비교
			String movieRanking = jTextField.getText();
			String[] movieInfo = movieRanking.split(",");
			Map<String, Object> movieMap = new HashMap<String, Object>();
			movieMap.put("rank", movieInfo[0]);
			movieMap.put("movieNm", movieInfo[1]);
			movieMap.put("audiCnt", movieInfo[2]);
			movieListMap.add(movieMap);
			for(Map movie:movieListMap) {
				System.out.println(movie);
			}
			//List<Movie> movieList = new ArrayList<Movie>();//Vector<Movie>
			//movieList.add(new Movie(movieInfo[0], movieInfo[1], movieInfo[2]));
			jComboBox.addItem(movieInfo[0]+movieInfo[1]); //액션이 1회에서 실행되지 않게 한다.
			toggle = true; //위 액션이 계속 실행되게 한다. 
			//Vector<Object> movieMap = new Vector<Object>();
			//movieMap.addElement(movieInfo);
			//JList jlist=new JList();
			//jlist.setListData(vector);
		}
		if(e.getSource()==deleteBtn) { //액션객체 비교
			jComboBox.removeAllItems();
			movieListMap = new ArrayList<Map>();
			toggle = false; //액션이 최초에는 실행되지 핞게 한다.
			for(Map movie:movieListMap) {
				System.out.println(movie);
			}
		}
		if(e.getSource()==jComboBox) { //액션객체 비교
			int index = jComboBox.getSelectedIndex();
			System.out.println(index);
			if(index > -1 && toggle)
				JOptionPane.showMessageDialog(null,movieListMap.get(index));
			/* 배경과 메세지창이 겹치지 않게 처리하는 방법 위 if문대신 아래 코드사용 
			if(index > -1 && toggle) {
				JOptionPane optionPane = new JOptionPane(movieListMap.get(index),JOptionPane.INFORMATION_MESSAGE);
				JDialog dialog = optionPane.createDialog("영화정보");
				dialog.setLocation(0,0);
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
			} */
			toggle = true;
		}
	}
	public static void main(String[] args) {
		new JComboBoxActionEvent();
	}
}