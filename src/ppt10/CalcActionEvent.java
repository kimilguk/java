package ppt10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
//Ctrl+Shift+O 를 하면 외부 라이브러리를 한번에 자동임포트 할 수 있다.

public class CalcActionEvent extends JFrame {
	private JPanel panel;//5행5열 간격3픽셀인 패널
	private JTextField tField;//계산식과 결과 출력
	private JButton[] buttons;//수식버튼들
	private String[] labels = { "(", ")", "", "Backspace", "C", "7", "8", "9", "/", "^", "4", "5", "6", "*", "%",
			"1", "2", "3", "-", "√", "0", ".", "", "+", "=", };//루트기호는 ㄷ 누른 후 한자키로 찾는다.
	private int index;//버튼의 인덱스값
	private String formula;//수식문자열
	private Object result;//계산결과
	public CalcActionEvent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("학생명의 전자계산기"); //학생명 에 여러분의 이름을 입력한다.
		tField = new JTextField(35);
		tField.setFont(new Font("굴림",Font.PLAIN,20));
		panel = new JPanel();
		panel.setLayout(new GridLayout(0, 5, 3, 3));
		buttons = new JButton[25];
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		for (int rows = 0; rows < 5; rows++) {
			for (int cols = 0; cols < 5; cols++) {
				buttons[index] = new JButton(labels[index]);
				if (cols >= 3) { //입력값 처리
					buttons[index].setForeground(Color.red);
					buttons[index].addActionListener(new ActionListener() {//학생이 작업, 현재 익명클래스를 람다식으로 변경한다. 
						@Override
						public void actionPerformed(ActionEvent e) {// getActionCommand()=버튼의 텍스트를 가져온다.
							formula = tField.getText();
							switch (e.getActionCommand()) {
							case "=":
								try {
									if(formula.indexOf("√")==0){//루트로 시작할 때만 정상작동
										String root = formula.replaceAll("√", "");
										result = Math.sqrt(Double.parseDouble(root));
									}else if (formula.indexOf("^")>0) {//중간에 ^가 있을때만 정상작동
										String[] power = formula.split("\\^"); //특수문자검색에서는 역슬래시가 필요하다.
										result = "학생이 Math클래스를 사용하여 위 2개의 변수값으로 제곱을 구하는 식을 작성한다.";//학생이 작업,
									}else {
										result = engine.eval(formula);
									}
									tField.setText(formula + "=" + result);
								} catch (ScriptException e1) {
									tField.setText(formula + "올바른 계산식이 아닙니다.");
								}
								break;
							case "C":
								tField.setText("");
								break;
							case "Backspace":
								formula = "학생이 formula.substring()을 사용하여끝 문자제거";//학생이 작업,
								tField.setText(formula);
								break;
							default: //위 조건에 맞니 않으면 선택한 문자를 이어 붙인다.
								tField.setText(formula + e.getActionCommand());
							}
						}
					});
				}else { //입력값 임시저장
					buttons[index].setForeground(Color.blue);
					buttons[index].addActionListener(new ActionListener() {//학생이 작업, 현재 익명클래스를 람다식으로 변경한다.
						@Override
						public void actionPerformed(ActionEvent e) {
							tField.setText(tField.getText() + e.getActionCommand());
							System.out.println(e.getActionCommand());
						}
					});
				}
				buttons[index].setBackground(Color.yellow);
				//버튼 액션이벤트 익명클래스 적용
				
				panel.add(buttons[index]);
				index++;
			}
		}
		add(tField, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		setVisible(true);
		pack(); //pack() 메소드는 setSize()메서드가 없어도 JFrame의 내용물에 알맞게 윈도우 크기를 조절한다.
	}
	public static void main(String args[]) {
		new CalcActionEvent();
	}
}
