package ppt09;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JPanelTest extends JFrame {
	
	public JPanelTest() throws HeadlessException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.orange);
		JButton b1 = new JButton("B1");
		b1.setBackground(Color.yellow);//이처럼 객체로 만들면 코딩이 편리해진다.
		panel1.add(b1);
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);//절대위치로 배치할 때 기본배치 값을 지운다.
		panel2.setBackground(Color.BLUE);
		JButton b2 = new JButton("B2");
		b2.setBackground(Color.green);
		b2.setLocation(30, 45);//시작점은 패널2의 좌상(0,0)좌표이다.
		b2.setSize(90, 20);//버튼 사이즈
		panel2.add(b2);

		setSize(300, 150);//JFrame 사이즈
		setLayout(new GridLayout(0, 2));//2열 표로 만든다.
		add(panel1);//JFrame에 패널컴포넌트를 추가한다.
		add(panel2);
		setVisible(true);//JFrame 보이기
	}
	public static void main(String[] args) {
		new JPanelTest();//객체 생성 = 실행

	}
}
