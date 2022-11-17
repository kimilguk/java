package ppt11;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsBasicTest extends JFrame {
	public class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			//super.paintComponent(g);//생략가능
			//여기에 도형을 그리는 코드를 넣는다.
			g.setColor(Color.YELLOW);
			g.fillOval(20, 30, 200, 200); //원 채워서 그리기
			g.setColor(Color.RED);
			g.drawRect(60, 80, 50, 50); //사각형 외곽선 그리기
			g.setColor(Color.BLACK); //호 그리기 선 색상
			g.drawArc(60, 80, 50, 50, 180, -180); // 왼쪽 눈
			g.drawArc(150, 80, 50, 50, 180, -180); // 오른쪽 눈
			g.drawArc(70, 130, 100, 70, 180, 180); // 입
		}
	}
	public GraphicsBasicTest() throws HeadlessException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("기초도형 그리기");
		setSize(300, 300);
		add(new MyPanel()); //프레임에 패널클래스를 추가한다.
		setVisible(true);
	}
	public static void main(String[] args) {
		new GraphicsBasicTest();
	}
}
