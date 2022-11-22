package ppt11;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class JListBoxActionEvent extends JFrame implements ActionListener {
	private JTextField jTextField;
	private JList<Object> jListBox;
	private Vector<Map> movieListMap = new Vector<Map>(); //List 대신 Vector 배열객체를 사용 
	private JButton addBtn,deleteBtn;//원격 데이터서버 자료를 가져오는 이벤트용 버튼
	public JListBoxActionEvent() throws HeadlessException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("일별 영화박스오피스 정보 가져오기"); //이후 OpenAPI 시간에 구현예정
		jTextField = new JTextField("1, 에일리언, 120");
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
			String[] movieInfo = movieRanking.split(",");
			Map<String, Object> movieMap = new HashMap<String, Object>();
			movieMap.put("rank", movieInfo[0]);
			movieMap.put("movieNm", movieInfo[1]);
			movieMap.put("audiCnt", movieInfo[2]);
			movieListMap.add(movieMap);
			for(Map movie:movieListMap) {
				System.out.println(movie);
			}
			jListBox.setListData(movieListMap);
		}
		if(e.getSource()==deleteBtn) { //액션객체 비교
			int index = jListBox.getSelectedIndex();
			if(index > -1) {
				movieListMap.removeElementAt(index); //먼저 데이터를 지운다.
				jListBox.setListData(movieListMap); //리스트박스 값을 다시 바인딩 한다.
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