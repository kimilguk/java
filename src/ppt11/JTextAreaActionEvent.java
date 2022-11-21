package ppt11;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JTextAreaActionEvent extends JFrame implements ActionListener {
	private JTextField jTextField;
	private JTextArea jTextArea;
	private JButton addBtn,deleteBtn;//원격 데이터서버 자료를 가져오는 이벤트용 버튼
	public JTextAreaActionEvent() throws HeadlessException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("일별 영화박스오피스 정보 가져오기"); //이후 OpenAPI 시간에 구현예정
		jTextField = new JTextField("일별 영화박스오피스 정보 가져오기");
		addBtn = new JButton("가져오기");
		deleteBtn = new JButton("지우기");
		jTextArea = new JTextArea(10, 100);//10행 100열의 출력 란
		jTextArea.setEditable(false);
		//스크롤 페인 스크롤이 있는 컨트이너를 만든다(아래)
		JScrollPane jPane = new JScrollPane(jTextArea);//멀티라인 내용을 스크롤로 감싸주기
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
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// 입력란에 엔터와 버튼을 눌렀을때 액션처리(아래)
		if(e.getSource()==addBtn || e.getSource()==jTextField) { //액션객체 비교
			String apiURL = jTextField.getText();
			jTextArea.append(apiURL + "\n");
			jTextField.requestFocus();//입력 포커스 상태
			jTextField.selectAll(); //신규내용 입력 편리하게 미리 선택한다.
			//jTextField.setCaretPosition(jTextField.getDocument().getLength());
		}
		if(e.getSource()==deleteBtn) { //액션객체 비교
			jTextArea.setText("");
		}
	}
	public static void main(String[] args) {
		new JTextAreaActionEvent();
	}
}
