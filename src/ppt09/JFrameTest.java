package ppt09;

import java.awt.HeadlessException;
import javax.swing.JFrame;

public class JFrameTest extends JFrame {
	public JFrameTest() throws HeadlessException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		setTitle("컨테이너");
		setVisible(true);
	}
	public static void main(String[] args) {
		JFrameTest frameTest = new JFrameTest();
	}
}
