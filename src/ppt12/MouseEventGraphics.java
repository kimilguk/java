package ppt12;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseEventGraphics extends JFrame {
	private int x,y; //마우스 클릭한 좌표를 동적으로 저장
	public class MyPanel extends JPanel {
		public MyPanel() {
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					x = e.getX();
					y = e.getY();
					repaint();
				}
			});
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.MAGENTA); //new Color(255, 0, 255) 동일한 결과이다.
			g.fillRect(x, y, 100, 100);
		}
	}
	public MouseEventGraphics() throws HeadlessException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("마우스이벤트와 그래픽의 결합");
		setSize(300, 300); 
		add(new MyPanel()); //프레임에 패널클래스를 추가한다.
		setVisible(true);
	}
	public static void main(String[] args) {
		new MouseEventGraphics(); //객체 실행
	}
}
