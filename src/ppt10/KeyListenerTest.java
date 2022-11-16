package ppt10;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class KeyListenerTest extends JFrame {
	//클래스변수
	JPanel jPanel;
	int n1, n2, n3;
	JButton jButton1, jButton2, jButton3;
	public KeyListenerTest() throws HeadlessException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 디자인 객체 생성
		setSize(300, 150);
		setTitle("슬롯머신");
		//setLayout(null);
		jPanel = new JPanel();
		//패널에 키보드 이벤트 추가
		jPanel.requestFocus();
		jPanel.setFocusable(true);
		//키리스너 이벤트 구현
		jPanel.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				//엔터 키를 눌렀을 때 액션 코드 추가
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					n1 = (int) (Math.random()*10); //0부터 9까지 랜덤한 수 저장
					n2 = (int) (Math.random()*10); //0부터 9까지 랜덤한 수 저장
					n3 = (int) (Math.random()*10); //0부터 9까지 랜덤한 수 저장
					jButton1.setText(Integer.toString(n1));
					jButton2.setText(Integer.toString(n2));
					jButton3.setText(Integer.toString(n3));
				}
			}
		});
		jButton1 = new JButton("" + n1);
		jButton2 = new JButton("" + n2);
		jButton3 = new JButton("" + n3);
		jPanel.add(jButton1);
		jPanel.add(jButton2);
		jPanel.add(jButton3);
		//-------------------------
		add(jPanel);
		setVisible(true);
	}
	public static void main(String[] args) {
		new KeyListenerTest();
	}
}
