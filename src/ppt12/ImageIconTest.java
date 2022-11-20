package ppt12;

import java.awt.Button;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageIconTest extends JFrame {
	Image img, resizeImg;
	private int pos_x;
	private JButton btnLeft, btnRight;
	public class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(resizeImg, pos_x, 50, this);//(Image,x좌표,y좌표,그리기 알림객체)
		}
		public MyPanel() {
			btnLeft = new JButton("후진");
			btnRight = new JButton("전진");
			add(btnLeft);
			add(btnRight);
			btnLeft.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					pos_x -= 10; //pos_x = pos_x-10의 단축코드
					repaint(); //x좌표에 -10픽셀로 적용 후 컴포넌트를 다시 그림 
				}
			});
			btnRight.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					pos_x += 10; //pos_x = pos_x+10의 단축코드
					repaint(); //x좌표에 +10픽셀로 적용 후 컴포넌트를 다시 그림 
				}
			});
		}
	}
	public ImageIconTest() throws HeadlessException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon = new ImageIcon("./src/car.png");
		img = icon.getImage(); //이미지파일을 추출하여 Image 변수에 저장
		resizeImg = img.getScaledInstance(200, 100, Image.SCALE_SMOOTH);//이미지크기변경
		setTitle("이미지아이콘 테스트");
		setSize(600, 200); 
		add(new MyPanel()); //프레임에 패널클래스를 추가한다.
		setVisible(true);
	}
	public static void main(String[] args) {
		new ImageIconTest();
	}
}
