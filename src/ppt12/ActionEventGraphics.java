package ppt12;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ActionEventGraphics extends JFrame {

	public class MyPanel extends JPanel implements ActionListener {
		private int light_number; //신호등변환수(빨,녹,황)
		public MyPanel() {
			setLayout(new BorderLayout()); //패널의 레이아웃 설정
			JButton jButton = new JButton("신호 변경"); //버튼객체생성
			jButton.addActionListener(this); //버튼에 액션리스너 추가
			add(jButton, BorderLayout.SOUTH); //패널에 버튼을 추가
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLACK); //아래 외곽선그리기
			g.drawOval(100, 10, 100, 100);
			g.drawOval(200, 10, 100, 100);
			g.drawOval(300, 10, 100, 100);
			if (light_number == 0) {
				g.setColor(Color.RED);
				g.fillOval(100, 10, 100, 100);
			} else if (light_number == 1) {
				g.setColor(Color.GREEN);
				g.fillOval(200, 10, 100, 100);
			} else {
				g.setColor(Color.YELLOW);
				g.fillOval(300, 10, 100, 100);
			}
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			//액션이벤트 처리 ++변수는 if문으로 비교하기 전 먼저 더하기 연산을 한다.(아래)
			if (++light_number >= 3)
				light_number = 0;//3이 나오면, 신호등을 그리기 전에 0으로 초기화 한다.
			repaint();//화면을 업데이트. = paintComponent를 재 실행하는 효과.
		}
	}
	public ActionEventGraphics() throws HeadlessException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("액션이벤트와 그래픽의 결합");
		setSize(500, 200); 
		add(new MyPanel()); //프레임에 패널클래스를 추가한다.
		setVisible(true);
	}
	public static void main(String[] args) {
		new ActionEventGraphics(); //객체 실행
	}
}
