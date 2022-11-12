package ppt09;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.text.NumberFormatter;

public class ComponentTest extends JFrame {
	private JPanel panel1, panel2;//패널 2개로 화면을 구성할 것이다.
	private JTextField textField, passwordField, tformated;//3개
	private JComboBox<String> combo;//콤보박스 1개를 사용할 것이다.
	private JSpinner spinner;//스피너 객체 1개를 사용할 것이다.
	private SpinnerModel model;//스피너에서 시간모델 1개를 사용할 것이다.
	private JButton jButton;//기본버튼 1개사용
	private JCheckBox[] jCheckBox;//체크박스 1개사용
	private ButtonGroup buttonGroup;//라디오버튼그룹 1개사용
	private JRadioButton[] jRadioButton;//라디오버튼 1개사용
	
	public ComponentTest() throws HeadlessException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,400);
		setTitle("컴포넌트 테스트");
		setLayout(new GridLayout(2,1));//2행 1열로 레이아웃을 구성한다.
		//내부컴포넌트 시작
		panel1 = new JPanel();
		textField = new JTextField("J텍스트필드 영역");
		panel1.add(textField);
		passwordField = new JPasswordField(20);//입력칸 크기20
		panel1.add(passwordField);
		tformated = new JFormattedTextField(new NumberFormatter());
		tformated.setPreferredSize(new Dimension(100,30));
	    panel1.add(tformated);
		String[] rainbow = {"빨", "주", "노", "초", "파", "남","보"};
		combo = new JComboBox<String>(rainbow);
		combo.setEditable(true);//수정도 가능하다.
		combo.setFont(new Font("굴림",Font.PLAIN,20));
		panel1.add(combo);
		model = new SpinnerDateModel();
	    spinner = new JSpinner(model);
	    panel1.add(spinner);
	    add(panel1);//JFrame에 패널1추가
	    //-----------------------------
	    panel2 = new JPanel();
	    jButton = new JButton("J버튼 영역");
	    panel2.add(jButton);
	    jCheckBox = new JCheckBox[rainbow.length];
	    for(int i=0; i<rainbow.length; i++){
	    	jCheckBox[i] = new JCheckBox(rainbow[i]);
			panel2.add(jCheckBox[i]);
		}
	    buttonGroup = new ButtonGroup();//다중선택방지 객체
	    jRadioButton = new JRadioButton[rainbow.length];
	    for(int i=0; i<rainbow.length; i++){
	    	jRadioButton[i] = new JRadioButton(rainbow[i]);
	    	buttonGroup.add(jRadioButton[i]);//다중선택방지 처리
			panel2.add(jRadioButton[i]);
		}
	    add(panel2);//JFrame에 패널2추가
	    //내부 컴포넌트 끝
		setVisible(true);
	}
	public static void main(String[] args) {
		new ComponentTest();//객체를 실행한다.
	}
}
