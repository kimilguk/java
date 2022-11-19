package ppt11;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FontTest extends JFrame {
	Font f1, f2; //굴림 과 Arial 글꼴 사용
	public class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			//super.paintComponent(g); 생략가능
			g.setFont(f1);
			g.drawString("굴림 20픽셀 한글은이탤릭체 없음", 10, 30);
			g.setFont(f2);
			g.drawString("Arial 20pixel Bold+Italic", 10, 60);
		}
	}
	public FontTest() throws HeadlessException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1 = new Font("gulim", Font.BOLD|Font.ITALIC, 20);
		f2 = new Font("arial", Font.BOLD|Font.ITALIC, 20);
		setTitle("폰트 테스트");
		setSize(400, 200); 
		add(new MyPanel()); //프레임에 패널클래스를 추가한다.
		setVisible(true);
	}
	public static void main(String[] args) {
		new FontTest(); //객체 실행
	}
}
