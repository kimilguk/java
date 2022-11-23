package ppt13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Notepad extends JFrame implements ActionListener {
	//멤버변수,화면은 텍스트영역과 메뉴바로 구성된다.
    private JTextArea textArea = new JTextArea(); //문자열 수정화면
    JMenuBar menubar = new JMenuBar(); //메뉴
    JFileChooser chooser = new JFileChooser(); //기존에 개발된 파일선택 컴포넌트
    String fileName = ""; //저장하거나 불러올 파일이름변수
    String cmd; //액션리스너 이벤트구현에 사용할 명령어변수
	@Override
	public void actionPerformed(ActionEvent e) {
		cmd = e.getActionCommand();
        switch (cmd) {
        case "새파일":
            newFile();
            break;
        case "열기":
            openFile();
            break;
        case "저장":
            if(fileName.equals("")) { //다른이름으로 저장과 일반 저장을 구분하기 위함, 처음 실행시 일반저장버튼을 눌렀을때 chooser가 열리도록 함
               int ret = chooser.showSaveDialog(null); //현재는 윈도우에 출력한다. 만약 (this)면 JFrame에 출력한다. 
               if(ret != chooser.APPROVE_OPTION) {
                  JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다!", "경고", JOptionPane.WARNING_MESSAGE);
                  return;
               }
               fileName = chooser.getSelectedFile().getPath();
            }
            saveFile(textArea.getText()); //저장
            break;
        case "다른이름으로저장": //무조건 chooser로 다이얼로그 열어서 저장
            int ret = chooser.showSaveDialog(null);
            if (ret == JFileChooser.APPROVE_OPTION) {
                fileName = chooser.getSelectedFile().getPath();
                saveFile(textArea.getText());
            }
            break;
        case "종료":
        	System.exit(0);
            break;
        }
	}
	//액션에서 사용하는 외부메서드 생성(아래)
	/* 새파일 */
    public void newFile() {
    	setTitle("새파일");
    	fileName="";
    	textArea.setText("");
    }
    /* 열기 */
    public void openFile() {
        int ret = chooser.showOpenDialog(null);
        if (ret != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            File inFile = chooser.getSelectedFile();
            BufferedReader in;
            try {
                in = new BufferedReader(new FileReader(inFile));
                String c;
                textArea.setText("");
                while ((c = in.readLine()) != null) {
                	textArea.append(c + "\n");//\r\n
                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        fileName = chooser.getSelectedFile().toString();
        setTitle(chooser.getSelectedFile().getName());
    }
    /* 파일 저장 */
    public void saveFile(String fn) {
    	BufferedWriter out = null;
    	File file = new File(fileName);
    	try {
    		out = new BufferedWriter(new FileWriter(file));
    		out.write(fn);
    		setTitle(file.getName());
    		out.close();
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    //생성자 메서드
    public Notepad() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("메모장으로 스트림 입출력 구현");
        setSize(500, 500);
        //1.대메뉴생성
        String[] topMenuName = { "파일" }; //대메뉴 이름
        JMenu[] topMenu = new JMenu[1]; //대메뉴 컴포넌트 크기
        for (int i = 0; i < topMenuName.length; i++) {
        	topMenu[i] = new JMenu(topMenuName[i]); //JMenu객체 생성
        	menubar.add(topMenu[i]); //메뉴바에 대메뉴 컴포넌트 추가
        }
        setJMenuBar(menubar); //JMenuBar객체에 위 메뉴바 추가
        //2.서브메뉴생성
        String[] subMenuName = { "새파일", "열기", "저장", "다른이름으로저장", "종료" };
        JMenuItem[] subMenuItem = new JMenuItem[5]; //서브메뉴 컴포넌트 크기
        for (int i = 0; i < subMenuName.length; i++) {
        	subMenuItem[i] = new JMenuItem(subMenuName[i]); //JMenuItem객체 생성
        	subMenuItem[i].addActionListener(this); //서브메뉴에 액션 리스너 적용
            topMenu[0].add(subMenuItem[i]); //대메뉴에 서브메뉴 컴포넌트 추가
        }
        //JFrame에 컴포넌트 추가
        JScrollPane jPane = new JScrollPane(textArea);//멀티라인 내용을 스크롤로 감싸주기
        add(jPane); //JFrame에 스크롤페인 컨테이너 추가
        setVisible(true);
    }
    public static void main(String[] args) {
        new Notepad(); //객체 실행
    }
}
