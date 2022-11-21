package ppt11;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JCheckBoxActionEvent extends JFrame implements ActionListener {
	JPanel jPanel;	JLabel jLabel;
	JCheckBox jBox1, jBox2, jBox3;
	JButton jButton;
	public JCheckBoxActionEvent() throws HeadlessException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		setLayout(null); //초기 FlowLayout를 제거 후 아래 html로 디자인을 줄수도 있다.
		jLabel = new JLabel("<html><body><h2 style='color:orange'>주문하실 제품을 골라 주세요!");
		jLabel.setBounds(50,50,300,20); //원점과 대각선점으로 자리를 확보한다.
		jBox1 = new JCheckBox("치즈버거 4000원");
		jBox1.setBounds(100,100,150,20);
		jBox2 = new JCheckBox("불고기버거 4500원");
		jBox2.setBounds(100,150,150,20);
		jBox3 = new JCheckBox("콜라 1000원");
		jBox3.setBounds(100,200,150,20);
		jButton = new JButton("주문하기");
		jButton.setBounds(100,250,150,30); //버튼은 크기를 변경할 수 있다.
		jButton.addActionListener(this);
		add(jLabel);
		add(jBox1);add(jBox2);add(jBox3);
		add(jButton);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int amount=0; //주문금액 합계
		String msg=""; //주문내역 표시
		if(jBox1.isSelected()) {
			amount += 4000;
			msg += "치즈버거: 4000\n";
		}
		if(jBox2.isSelected()) {
			amount += 4500;
			msg += "불고기버거: 4500\n";
		}
		if(jBox3.isSelected()) {
			amount += 1000;
			msg += "콜라: 1000\n";
		}
		msg += "-----------------------\n";
		JOptionPane.showMessageDialog(this,msg+"합계: "+amount);
	}
	public static void main(String[] args) {
		new JCheckBoxActionEvent(); //객체 실행
	}

}