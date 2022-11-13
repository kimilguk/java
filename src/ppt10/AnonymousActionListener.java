package ppt10;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AnonymousActionListener extends JFrame {
	private JPanel jPanel;
	private JButton button;
	private JLabel label;
	private int counter;
	public AnonymousActionListener() throws HeadlessException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,150);
		setTitle("액션리스너테스트");
		jPanel = new JPanel();
		button = new JButton("증가");
		label = new JLabel("현재의 카운터 값: "+counter);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				counter++;
				label.setText("현재의 카운터 값: "+counter);				
			}
		});//리스너는 이벤트 알림을 대기하는 기능의 메서드 이다
		jPanel.add(label);
		jPanel.add(button);
		add(jPanel);
		setVisible(true);
	}
	public static void main(String[] args) {
		new AnonymousActionListener();
	}
}
