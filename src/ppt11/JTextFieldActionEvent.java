package ppt11;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JTextFieldActionEvent extends JFrame implements ActionListener {
	private JPanel jPanel;
	private JButton jButton;
	private JTextField input, result;
	public JTextFieldActionEvent() throws HeadlessException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 150);
		setTitle("제곱 계산하기");
		input = new JTextField(15);
		result = new JTextField(15);
		result.setEnabled(false);
		jButton = new JButton("제곱계산하기");
		jPanel = new JPanel();
		jPanel.add(new JLabel("숫자 입력: "));
		jPanel.add(input);
		jPanel.add(new JLabel("제곱한 값: "));
		jPanel.add(result);
		jPanel.add(jButton);
		add(jPanel);
		setVisible(true);
		input.addActionListener(this);
		jButton.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jButton || e.getSource()==input) { //액션객체 비교
			int value = Integer.parseInt(input.getText());
			result.setText(String.valueOf(value*value));
		}
	}
	public static void main(String[] args) {
		new JTextFieldActionEvent();
	}
}
