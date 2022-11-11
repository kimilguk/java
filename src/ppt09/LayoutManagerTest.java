package ppt09;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;

public class LayoutManagerTest extends JFrame {
	public LayoutManagerTest() throws HeadlessException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("LayoutManagerTest");
		setSize(350, 150);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		//setLayout(new BorderLayout());//상,하,좌,우,중앙 상수값을 사용
		//setLayout(new GridLayout(0, 3));//(행row, 열column)
		add(new JButton("B1"), BorderLayout.NORTH);
		add(new JButton("B2"), BorderLayout.SOUTH);
		add(new JButton("B3"), BorderLayout.EAST);
		add(new JButton("B4"), BorderLayout.WEST);
		add(new JButton("B5"), BorderLayout.CENTER);
		setVisible(true);
	}
	public static void main(String[] args) {
		new LayoutManagerTest();//객체 생성
	}
}
